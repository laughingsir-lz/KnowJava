package com.lz.ssm.mapper;

import com.lz.ssm.domain.Employee;
import com.lz.ssm.domain.Role;
import com.lz.ssm.qo.EmployeeQueryObject;
import com.lz.ssm.qo.RoleQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    int queryCount(RoleQueryObject qo);

    List<Role> queryRole(RoleQueryObject qo);

    List<Role> selectByEmployeeId(Long id);

    HashSet<Long> selectRoleIdByEmployeeId(Long id);

    void deleteRoleIdByEmployeeId(Long id);

    void insertRelation(@Param("id") Long id, @Param("permissionId") Long permissionId);

    void deletePermissionByRoleId(Long id);
}