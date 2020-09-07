package com.lz.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Department;
import com.lz.ssm.mapper.DepartmentMapper;
import com.lz.ssm.qo.DepartmentQueryObject;
import com.lz.ssm.qo.PageResult;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.service.IDepartmentService;
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
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void delete(Long id) {
        departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void save(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public Department get(Long id) {
        Department department = departmentMapper.selectByPrimaryKey(id);
        return department;
    }

    @Override
    public List<Department> listAll() {
        List<Department> departments = departmentMapper.selectAll();
        return departments;
    }

    @Override
    public void update(Department record) {
        departmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Department> query(DepartmentQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
//        int count = departmentMapper.queryCount(qo);
//        return new PageResult<>(qo.getCurrentPage(),qo.getPageSize(),count,
//                count==0? Collections.emptyList():departmentMapper.queryDep(qo));
        List<Department> departments = departmentMapper.queryDep(qo);
        System.out.println(departments);
        return new PageInfo<>(departments);
    }
}
