package com.lz.ssm.service;

import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Role;
import com.lz.ssm.qo.RoleQueryObject;
import com.lz.ssm.qo.PageResult;

import java.util.List;

/**
 * 处理角色的服务
 *
 * @author zzz
 */
public interface IRoleService {
    /**
     * 根据id删除角色
     *
     * @param id 角色id
     */
    void delete(Long id);

    /**
     * 存入一个角色信息
     *
     * @param role 角色
     * @param ids
     */
    void save(Role role, Long[] ids);

    /**
     * 查找到一个角色信息
     *
     * @param id 角色id
     * @return 返回角色信息e
     */
    Role get(Long id);

    /**
     * 查询所有角色
     *
     * @return 返回所有的角色信息
     */

    List<Role> listAll();

    /**
     * 更新一个角色信息
     *
     * @param role 角色信息
     * @param ids
     */
    void update(Role role, Long[] ids);

    /**
     * 分页过滤查询
     *
     * @param qo 分页查询参数
     * @return 分页过滤结果
     */
    PageInfo<Role> query(RoleQueryObject qo);
}
