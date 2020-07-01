package com.lz.listday02.practice04;

import java.util.Objects;

/**
 * @ClassName User
 * @Description:  Hashset去重对象测试类
 * @Author: zzz
 **/
public class User {
    private String name;
    public User(String name) {
        this.name = name;
    }
   //去重就必须重写  equals(Object o)方法
    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        User user = (User) o;
        return Objects.equals(name, user.name);
    }
    //去重就必须重写 hashCode() 方法
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
