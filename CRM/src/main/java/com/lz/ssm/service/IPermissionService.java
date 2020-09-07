package com.lz.ssm.service;

import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Permission;
import com.lz.ssm.qo.PageResult;
import com.lz.ssm.qo.PermissionQueryObject;

import java.util.List;

/**
 * 处理权限的服务
 *
 * @author zzz
 */
public interface IPermissionService {
    /**
     * 根据id删除权限
     *
     * @param id 权限id
     */
    void delete(Long id);

    /**
     * 存入一个权限信息
     *
     * @param permission 权限
     */
    void save(Permission permission);

    /**
     * 查找到一个权限信息
     *
     * @param id 权限id
     * @return 返回权限信息e
     */
    Permission get(Long id);

    /**
     * 查询所有权限
     *
     * @return 返回所有的权限信息
     */

    List<Permission> listAll();

    /**
     * 更新一个权限信息
     *
     * @param permission 权限信息
     */
    void update(Permission permission);

    /**
     * 分页过滤查询
     *
     * @param qo 分页查询参数
     * @return 分页过滤结果
     */
    PageInfo<Permission> query(PermissionQueryObject qo);

    void reload();

    /**
     * 通过员工id查询到对应的权限id
     *
     * @param id 员工id
     * @return 权限表达式集合
     */
    List<String> queryByEmployeeId(Long id);
}
