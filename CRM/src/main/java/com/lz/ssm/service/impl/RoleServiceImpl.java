package com.lz.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Role;
import com.lz.ssm.mapper.PermissionMapper;
import com.lz.ssm.mapper.RoleMapper;
import com.lz.ssm.qo.RoleQueryObject;
import com.lz.ssm.qo.PageResult;
import com.lz.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 处理部门服务的实现
 *
 * @author zzz
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void delete(Long id) {
        roleMapper.deletePermissionByRoleId(id);
        roleMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void save(Role role, Long[] ids) {
        roleMapper.insert(role);
        if (ids != null && ids.length > 0) {
            for (Long permissionId : ids) {
                //if(set.add(roleId)){
                roleMapper.insertRelation(role.getId(), permissionId);
                // }
            }
        }
    }

    @Override
    public Role get(Long id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public List<Role> listAll() {
        List<Role> roles = roleMapper.selectAll();
        return roles;
    }

    @Override
    public void update(Role record, Long[] ids) {
        roleMapper.deletePermissionByRoleId(record.getId());
        roleMapper.updateByPrimaryKey(record);
        if (ids != null && ids.length > 0) {
            for (Long permissionId : ids) {
                roleMapper.insertRelation(record.getId(), permissionId);
            }
        }
    }

    @Override
    public PageInfo<Role> query(RoleQueryObject qo) {
//        int count = roleMapper.queryCount(qo);
//        return new PageResult<>(qo.getCurrentPage(),qo.getPageSize(),count,
//                count==0?Collections.emptyList():roleMapper.queryRole(qo));
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        return new PageInfo<>(roleMapper.queryRole(qo));
    }
}
