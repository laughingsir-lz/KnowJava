package com.lz.ssm.service;

import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Department;
import com.lz.ssm.qo.DepartmentQueryObject;
import com.lz.ssm.qo.PageResult;


import java.util.List;

/**
 * 处理部门的服务
 *
 * @author zzz
 */
public interface IDepartmentService {
    /**
     * 根据id删除部门
     *
     * @param id 部门id
     */
    void delete(Long id);

    /**
     * 存入一个部门信息
     *
     * @param department 部门
     */
    void save(Department department);

    /**
     * 查找到一个部门信息
     *
     * @param id 部门id
     * @return 返回部门信息
     */
    Department get(Long id);

    /**
     * 查询所有部门
     *
     * @return 返回所有的部门信息
     */

    List<Department> listAll();

    /**
     * 更新一个部门信息
     *
     * @param department 部门信息
     */
    void update(Department department);

    /**
     * 分页过滤查询
     *
     * @param qo 分页查询参数
     * @return 分页过滤结果
     */
    PageInfo<Department> query(DepartmentQueryObject qo);
}
