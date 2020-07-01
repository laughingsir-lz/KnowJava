package com.lz.listday02.practice06;

/**
 * @ClassName User
 * @Description:
 * @Author: zzz
 **/
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 重写compareTO方法，确比较规则 按年龄大小排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(User o) {
        if (this.age>o.age){
            return 1;
        }else if (this.age<o.age){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
