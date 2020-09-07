package com.lz.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.controller.DepartmentController;
import com.lz.ssm.domain.Permission;
import com.lz.ssm.mapper.PermissionMapper;
import com.lz.ssm.qo.PageResult;
import com.lz.ssm.qo.PermissionQueryObject;
import com.lz.ssm.service.IPermissionService;
import com.lz.ssm.util.RequiredPermission;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 处理部门服务的实现
 *
 * @author zzz
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private ApplicationContext context;


    @Override
    public void delete(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void save(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public Permission get(Long id) {
        Permission permission = permissionMapper.selectByPrimaryKey(id);
        return permission;
    }

    @Override
    public List<Permission> listAll() {
        List<Permission> permissions = permissionMapper.selectAll();
        return permissions;
    }

    @Override
    public void update(Permission record) {
        permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Permission> query(PermissionQueryObject qo) {
//        int count = permissionMapper.queryCount(qo);
//        return new PageResult<>(qo.getCurrentPage(), qo.getPageSize(), count,
//                count == 0 ? Collections.emptyList() : permissionMapper.queryPermission(qo));
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        return new PageInfo<>(permissionMapper.queryPermission(qo));
    }

    @Override
    public void reload() {
        //先把数据库中的所有权限数据查询出来
        List<Permission> permissionList = permissionMapper.selectAll();
        // Set<Permission> expressions = permissionMapper.selectSetAll();
        Set<String> expressions = new HashSet<>();
        for (Permission permission : permissionList) {
            expressions.add(permission.getexpression());
        }
        //获取到所有的控制器的处理方法
//        Method[] methods = DepartmentController.class.getDeclaredMethods();
        //直接使用反射取方法不通用
        //所有的对象都在spring容器  直接使用容器来加载所有的控制器
        Map<String, Object> beans = context.getBeansWithAnnotation(Controller.class);
        //  System.out.println(1);
        Collection<Object> controllers = beans.values();


        //遍历每一个控制器对象  反射获取里面的方法
        for (Object controller : controllers) {
            // 贴了注解的对象会被CGLIB动态代理  直接判断是不是动态代理对象
            if (!AopUtils.isCglibProxy(controller)) {
                // 跳过本次循环 进入下一次循环
                continue;
            }
            // shiro 使用了动态代理 （CGLIB 继承实现） 所以要使用注解的父类去拿权限方法
            Method[] methods = controller.getClass().getSuperclass().getDeclaredMethods();
            for (Method method : methods) {
                //获取方法上的注解
                RequiresPermissions permission = method.getAnnotation(RequiresPermissions.class);
                //该方法有目标注解
                if (permission != null) {
                    String name = permission.value()[1];
                    String expression = permission.value()[0];
                    //存到数据库之前必须和数据库之间的数据去重
                    //创建对象封装数据
                    //if(!expressions.contains(expression)){
                    if (expressions.add(expression)) {
                        Permission permission1 = new Permission();
                        permission1.setexpression(expression);
                        permission1.setName(name);
                        permissionMapper.insert(permission1);
                    }
                }
            }
        }
        //获取方法的注解 （name  expression）
        //创建Permission对象 封装数据 保存
    }

    @Override
    public List<String> queryByEmployeeId(Long id) {
        return permissionMapper.queryByEmployeeId(id);
    }
}
