package com.lz.ssm.mapper;

import com.lz.ssm.domain.Employee;
import com.lz.ssm.domain.Permission;
import com.lz.ssm.qo.EmployeeQueryObject;
import com.lz.ssm.qo.PermissionQueryObject;

import java.util.List;
import java.util.Set;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    Set<Permission> selectSetAll();

    int updateByPrimaryKey(Permission record);

    int queryCount(PermissionQueryObject qo);

    List<Permission> queryPermission(PermissionQueryObject qo);


    List<String> queryByEmployeeId(Long id);
}