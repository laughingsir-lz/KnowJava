package com.lz.crud.domain;

import javax.management.loading.PrivateMLet;
import java.math.BigDecimal;

/**
 * @ClassName Emplyee
 * @Description:
 * @Author: zzz
 **/
public class Employee {
    private Long id;
    private String name;
    private int age;
    private String sex;
    private BigDecimal salary;
    public Employee(){}

    public Employee(Long id, String name, int age, String sex, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                '}';
    }
}
