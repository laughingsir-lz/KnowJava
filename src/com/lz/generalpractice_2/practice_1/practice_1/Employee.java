package com.lz.generalpractice_2.practice_1.practice_1;

/**
 * Employee 类
 */
public class Employee {
    static int num = 0;
    private int id;
    private String name;
    private int age;
    private double salary;
    private String idnumber;
    public Employee() {
    }
    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        num++;
        if (age < 18) {
            throw new LowAgeException("年龄低");
        }
        if (age > 60) {
            throw new HighAgeException("年龄高");
        }
        if (name == null ||name.trim().equals("")) {
             throw new NullPointerException("名字不能为空");
        }
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Employee.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", idnumber='" + idnumber + '\'' +
                '}';
    }
}
