package com.lz.crud.dao;

import com.lz.crud.domain.Employee;

import java.util.List;

/**
 * @author zzz
 */
public interface IEmployeeDao {
    /**
     * 插入一条员工数据
     * @param employee 员工对象
     * @return 返回结果提示
     */
    String insert(Employee employee);

    /**
     * 删除指定id的员工
     * @param id 员工id
     * @return 返回删除结果提示
     */
    String delete(Long id);

    /**
     * 更新一条员工的信息
     * @param employee 员工对象
     * @return 返回更新的结果提示
     */
    String update(Employee employee);

    /**
     * 查询指定id的员工信息
     * @param id 员工id
     * @return  Employee 返回员工对象信息
     */
    Employee selectOne(Long id);

    /**
     * 查询当前员工表的所有员工信息
     * @return 员工信息集合
     */
    List<Employee> selectList();
}
