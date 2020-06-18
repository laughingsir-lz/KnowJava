package com.lz.generalpractice_1.expandpractice_1;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Employee 类
 */
public class Employee {
    private String name;
    private int age;
    private BigDecimal salary;
    private Date hireDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = new BigDecimal(salary);
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) throws ParseException {
        //创建格式化对象sdf
        SimpleDateFormat sdf = new SimpleDateFormat();
        //设置格式
        String patten = "yyyy-MM-dd";
        sdf.applyPattern(patten);
        Date date = sdf.parse(hireDate);
        this.hireDate = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", hireDate=" + hireDate.toLocaleString() +
                '}';
    }
}
