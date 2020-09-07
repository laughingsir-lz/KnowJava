package com.lz.restful.controller;

import com.lz.restful.domain.Department;
import com.lz.restful.domain.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @date 2020/9/6  21:48
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    /**
     * 查询所有得部门资源
     * @returns
     *
     */
    @GetMapping
    public List<Department> list(){
        ArrayList<Department> departments = new ArrayList<>();
        departments.add(new Department(1L,"水浒",null));
        departments.add(new Department(2L,"三国",null));
        departments.add(new Department(3L,"红楼",null));
        departments.add(new Department(4L,"西游",null));
        return departments;
    }


    /**
     * 得到某一个部门的资源
     * @param id 部门id
     * @return
     */
    @GetMapping("/{id}")
    public Department list(@PathVariable Long id){
        System.out.println(id);
        Department 水浒 = new Department(1L, "水浒", null);
        ArrayList<Employee> employees = new ArrayList<>();
        Employee 花容 = new Employee(1L, "花容");
        Employee 林冲 = new Employee(1L, "林冲");
        employees.add(林冲);
        employees.add(花容);
        水浒.setEmployees(employees);
        return 水浒;
    }

    /**
     * 查询某个部门的某个员工
     * @param id
     * @param empId
     * @return
     */

    @GetMapping("/{id}/{empId}")
    public Employee list(@PathVariable Long id, @PathVariable Long empId){
        Department 水浒 = new Department(id, "水浒", null);
        System.out.println(水浒);
        System.out.println("用户id"+empId);
        ArrayList<Employee> employees = new ArrayList<>();
        Employee 花容 = new Employee(empId, "花容");
        return 花容;
    }

    /**
     * 修改员工的信息  使用put请求  更新全部信息
     * @param id
     * @param empId
     * @return 返回全新对象的信息
     */
    @PutMapping("/{id}/{empId}")
    public Employee put(@PathVariable Long id, @PathVariable Long empId){
        Department 水浒 = new Department(id, "水浒", null);
        System.out.println(水浒);
        System.out.println("用户id"+empId);
        ArrayList<Employee> employees = new ArrayList<>();
        Employee 花容 = new Employee(empId,水浒.getName());
        return 花容;
    }
    


}
