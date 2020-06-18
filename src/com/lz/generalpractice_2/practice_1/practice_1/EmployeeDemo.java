package com.lz.generalpractice_2.practice_1.practice_1;

public class EmployeeDemo {
    public static void main(String[] args) {
       //Employee employee1 = new Employee(1, "xxx", 17);//年龄低异常
       // Employee employee2 = new Employee(1, "zzz", 61);//年龄高异常
        //Employee employee3 = new Employee(1, "", 20);//名字不能为空
        addSalary(6000);//工资高异常
    }
    public static  void addSalary(double addSalary) {
        if (addSalary > 5000) {
            throw new HighSalaryException("工资高异常");
        }
    }
}
