package com.lz.daopass.domain;

/**
 * @ClassName Student
 * @Description: Dao 模型 student
 * @Author: zzz
 **/
public class Student {
    private String name;
    private String email;
    private Integer age;
    private Long id;

    public Student() {
    }

    public Student(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Student(String name, String email, Integer age, Long id) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
