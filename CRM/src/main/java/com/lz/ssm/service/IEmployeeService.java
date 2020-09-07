package com.lz.ssm.service;

import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Employee;
import com.lz.ssm.qo.EmployeeQueryObject;
import com.lz.ssm.qo.PageResult;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 处理员工的服务
 *
 * @author zzz
 */
public interface IEmployeeService {
    /**
     * 根据id删除员工
     *
     * @param id 员工id
     */
    void delete(Long id);

    /**
     * 存入一个员工信息
     *
     * @param employee 员工
     * @param ids
     */
    void save(Employee employee, Long[] ids);

    /**
     * 查找到一个员工信息
     *
     * @param id 员工id
     * @return 返回员工信息e
     */
    Employee get(Long id);

    /**
     * 查询所有员工
     *
     * @return 返回所有的员工信息
     */

    List<Employee> listAll();

    /**
     * 更新一个员工信息
     *
     * @param employee 员工信息
     * @param ids
     */
    void update(Employee employee, Long[] ids);

    /**
     * 分页过滤查询
     *
     * @param qo 分页查询参数
     * @return 分页过滤结果
     */
    PageInfo<Employee> query(EmployeeQueryObject qo);

    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */

    Employee login(String username, String password);

    /**
     * 批量删除
     *
     * @param ids
     */
    void batchDelete(Long[] ids);

    /**
     * @param name
     * @return
     */

    Employee selectByName(String name);

    /**
     * @return
     */

    Workbook export();

    /**
     * @param file
     * @throws IOException
     */

    void inport(MultipartFile file) throws IOException;

    void updateByPrimaryKey(Employee record);

    boolean startStatus(Long id);

    boolean disableStatus(Long id);

    void updateStatus(Long id);

    List<Employee> selectByRoleSn(String... sn);
}
