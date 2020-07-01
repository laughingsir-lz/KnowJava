package com.lz.listday02.generalpractice03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Demo
 * @Description:
 * @Author: zzz
 **/
public class Demo {
    public static void main(String[] args) {
        //创建员工对象
        Employee employee1 = new Employee("小斌",22);
        Employee employee2 = new Employee("地雷",23);
        Employee employee3 = new Employee("吉吉",21);
        Employee employee4 = new Employee("东方菇凉",18);
        Employee employee5 = new Employee("独孤求败",28);
        Employee employee6 = new Employee("糖糖",25);
        //测试员工对象去重
        Employee employee7 = new Employee("糖糖",25);
        //创建员工对象的集合
        //添加员工
        Set<Employee> employeeSet1 = new HashSet<>();
        employeeSet1.add(employee1);
        employeeSet1.add(employee2);
        employeeSet1.add(employee3);
        Set<Employee> employeeSet2 = new HashSet<>();
        employeeSet2.add(employee4);
        employeeSet2.add(employee5);
        employeeSet2.add(employee6);
        employeeSet2.add(employee7);
        //通过构造器 创建部门对象
        Department department1 = new Department("部门一",employeeSet1);
        Department department2 = new Department("部门二",employeeSet2);
        //打印部门信息
        System.out.println(department1);
        System.out.println(department2);
    }
}
