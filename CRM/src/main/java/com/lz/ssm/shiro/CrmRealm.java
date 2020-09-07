package com.lz.ssm.shiro;

import com.lz.ssm.domain.Employee;
import com.lz.ssm.domain.Role;
import com.lz.ssm.mapper.EmployeeMapper;
import com.lz.ssm.mapper.PermissionMapper;
import com.lz.ssm.mapper.RoleMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zzz
 * @date 2020/8/26  10:54
 */
@Component
public class CrmRealm extends AuthorizingRealm {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleMapper roleMapper;


    /**
     * 提供认证信息给shiro
     * 该方法的返回值就决定了是否会抛出账号不存在的异常
     * 如果我返回null shiro 就会抛出异常
     * 如果我放回对象 shiro 就会从对象里拿出真正的密码，结果token中的密码去判断
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("------------------------  ------- ------------------------------------");
        // username 是令牌中的username 可能是假的
        String username = authenticationToken.getPrincipal().toString();
        //根据用户名查询数据库  是否存在这个对象  如果有就能取出真正的密码
        Employee employee = employeeMapper.selectByName(username);
        if (employee != null) {
            // 三个参数    账号 密码  数据
            //第一个参数主要作用是和subject绑定 （可以存对象）
            // 返回对象是包含的密码的
            return new SimpleAuthenticationInfo(employee, employee.getPassword(), this.getName());
        }
        // 没通过
        return null;
    }

    /**
     * 提供权限信息
     *
     * @param principalCollection
     * @return 代表了当前的subject 所拥有的权限/角色信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();

        if (!employee.isAdmin()) {
            //根据员工id查询该员工拥有的角色
            List<Role> roleList = roleMapper.selectByEmployeeId(employee.getId());
            //根据员工id查询拥有的权限
            roleList.forEach(role -> info.addRole(role.getSn()));
            List<String> permissions = permissionMapper.queryByEmployeeId(employee.getId());
            info.addStringPermissions(permissions);
        } else {
            info.addStringPermission("*:*");
            //方便以后判断是否管理员的时候直接使用
            info.addRole("ADMIN");
        }
//        info.addRole("HR");
//        info.addStringPermission("employee:save");
        return info;
    }
}
