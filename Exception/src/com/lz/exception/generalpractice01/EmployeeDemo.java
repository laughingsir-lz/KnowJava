package com.lz.exception.generalpractice01;

/**
 * 员工自定义异常测试类
 * @author zzz
 */
public class EmployeeDemo {
    public static void main(String[] args) {
        //年龄低异常
       //Employee employee1 = new Employee(1, "xxx", 17);
        //年龄高异常
       // Employee employee2 = new Employee(1, "zzz", 61);
        //名字不能为空
        //Employee employee3 = new Employee(1, "", 20);
        //工资高异常
        addSalary(6000);
    }

    /**
     * 增加工资的方法
     * @param addSalary
     */
    public static  void addSalary(double addSalary) {
        //工资增幅常量
        final double salary = 5000.00;
        if (addSalary > salary) {
            //抛出自定义 HighSalaryException 异常
            throw new HighSalaryException("工资高异常");
        }
    }
}
