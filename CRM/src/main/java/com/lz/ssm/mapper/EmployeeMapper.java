package com.lz.ssm.mapper;

import com.lz.ssm.domain.Employee;
import com.lz.ssm.qo.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    int queryCount(EmployeeQueryObject qo);

    List<Employee> queryEmp(EmployeeQueryObject qo);

    void insertRelation(@Param("employeeId") Long employeeId, @Param("roleId") Long roleId);

    /**
     * 用户名和密码验证
     *
     * @param username
     * @param password
     * @return
     */

    Employee selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 批量删除
     *
     * @param ids
     */
    void batchDelete(@Param("ids") Long[] ids);

    Employee selectByName(String name);

    void startStatus(Long id);

    void disableStatus(Long id);

    void updateStatus(Long id);

    List<Employee> selectByRoleSn(@Param("sn") String... sn);
}