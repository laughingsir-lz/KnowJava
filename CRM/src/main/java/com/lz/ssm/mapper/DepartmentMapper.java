package com.lz.ssm.mapper;

import com.lz.ssm.domain.Department;
import com.lz.ssm.qo.DepartmentQueryObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    int queryCount(DepartmentQueryObject qo);

    List<Department> queryDep(DepartmentQueryObject qo);
}