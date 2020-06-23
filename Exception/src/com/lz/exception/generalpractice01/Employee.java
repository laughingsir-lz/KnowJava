package com.lz.exception.generalpractice01;

/**
 * Employee 类
 * @author zzz
 */
public class Employee {
    static int num = 0;
    private int id;
    private String name;
    private int age;
    private double salary;
    private String idNumber;
    final private  int lowAge = 18;
    final private int highAge = 60;
    public Employee() {
    }
    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        num++;
        if (age < lowAge) {
            //抛出自定义 LowAgeException 异常
            throw new LowAgeException("年龄低");
        }
        if (age > highAge) {
            //抛出自定义 HighAgeException 异常
            throw new HighAgeException("年龄高");
        }
        if (name == null ||name.trim().equals("")) {
            //抛出自定义 NullPointerException 异常
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}
