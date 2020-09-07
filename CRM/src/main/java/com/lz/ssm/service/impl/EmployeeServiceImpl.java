package com.lz.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Employee;
import com.lz.ssm.exception.LogicException;
import com.lz.ssm.mapper.EmployeeMapper;
import com.lz.ssm.mapper.RoleMapper;
import com.lz.ssm.qo.EmployeeQueryObject;
import com.lz.ssm.qo.PageResult;
import com.lz.ssm.service.IEmployeeService;
import com.lz.ssm.util.PasswordUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * 处理部门服务的实现
 *
 * @author zzz
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void delete(Long id) {
        roleMapper.deleteRoleIdByEmployeeId(id);
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Employee> selectByRoleSn(String... sn) {

        return employeeMapper.selectByRoleSn(sn);
    }

    @Override
    public void save(Employee employee, Long[] roleIds) {
        //先加密密码    （用户名作为盐）
        String salt = UUID.randomUUID().toString().substring(0, 6);
        Md5Hash md5Hash = new Md5Hash(employee.getPassword(), salt, 2);
        employee.setPassword(md5Hash.toString());
        employee.setSalt(salt);
        employeeMapper.insert(employee);
        saveRoletion(employee, roleIds);
    }

    @Override
    public Employee get(Long id) {

        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> listAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public void update(Employee employee, Long[] roleIds) {

        roleMapper.deleteRoleIdByEmployeeId(employee.getId());
        //int i=1/0;
        employeeMapper.updateByPrimaryKey(employee);
        saveRoletion(employee, roleIds);
    }

    private void saveRoletion(Employee employee, Long[] roleIds) {
        if (roleIds != null && roleIds.length > 0) {
            for (Long roleId : roleIds) {
                employeeMapper.insertRelation(employee.getId(), roleId);
            }
        }
    }

    @Override
    public PageInfo<Employee> query(EmployeeQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        return new PageInfo<>(employeeMapper.queryEmp(qo));
    }

    @Override
    public Employee login(String username, String password) {

        // 查询数据库中是否有匹配的数据
        Employee employee = employeeMapper.selectByUsernameAndPassword(username, password);

        if (employee == null) {
            //通知调用者出现异常
            throw new LogicException("账号和密码不匹配");
        }
        return employee;
    }

    @Override
    public void batchDelete(Long[] ids) {
        employeeMapper.batchDelete(ids);
    }

    @Override
    public Employee selectByName(String name) {
        return employeeMapper.selectByName(name);
    }

    @Override
    public Workbook export() {
        //创建一个工作簿
        Workbook wb = new XSSFWorkbook();
        //创建工作表
        Sheet sheet = wb.createSheet("员工信息");
        //注意信息行的构建
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");
        row.createCell(2).setCellValue("邮箱");
        //查询员工数据
        List<Employee> employees = employeeMapper.selectAll();
        for (int i = 0; i < employees.size(); i++) {
            //创建行（索引 从 0 开始）
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(employees.get(i).getName());
            row.createCell(1).setCellValue(employees.get(i).getAge());
            row.createCell(2).setCellValue(employees.get(i).getEmail());
            //写入内容
        }
        return wb;
    }

    @Override
    public void inport(MultipartFile file) throws IOException {
        Workbook wb = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = wb.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            String name = row.getCell(0).getStringCellValue();
            row.getCell(1).setCellType(CellType.STRING);
            Integer age = Integer.valueOf(row.getCell(1).getStringCellValue());
            String email = row.getCell(2).getStringCellValue();
            Employee employee = new Employee();
            employee.setAge(age);
            employee.setEmail(email);
            employee.setName(name);
            employeeMapper.insert(employee);
        }
    }

    @Override
    public void updateByPrimaryKey(Employee record) {
        employeeMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean startStatus(Long id) {
        employeeMapper.startStatus(id);
        return false;
    }

    @Override
    public boolean disableStatus(Long id) {
        employeeMapper.disableStatus(id);
        return false;
    }

    @Override
    public void updateStatus(Long id) {
        employeeMapper.updateStatus(id);
    }
}
