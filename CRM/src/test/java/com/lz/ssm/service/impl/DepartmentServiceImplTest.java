package com.lz.ssm.service.impl;

import com.lz.ssm.domain.Department;
import com.lz.ssm.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceImplTest {
    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void delete() {
        departmentService.delete(1L);
    }

    @Test
    public void save() {
        Department department = new Department();
        department.setName("发展部");
        department.setSn("DV");
        departmentService.save(department);
    }

    @Test
    public void get() {
        System.out.println(departmentService.get(1L).toString());
    }

    @Test
    public void listAll() {
        departmentService.listAll().forEach(System.out::println);
    }

    @Test
    public void update() {
        Department department = new Department();
        department.setId(1L);
        department.setName("发展部(2)");
        department.setSn("DV");
        departmentService.update(department);
    }
}