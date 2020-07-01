package com.lz.listday02.practice06;

import com.lz.listday02.practice03.HashSetDemo;

import java.util.TreeSet;

/**
 * @ClassName ComparableDemo
 * @Description: 使用Comparable接口按照用户的年龄从小到大排序
 * @Author: zzz
 **/
public class ComparableDemo {
    public static void main(String[] args) {
        TreeSet<User> users = new TreeSet<>();
        users.add(new User("xxx",28));
        users.add(new User("sss",17));
        users.add(new User("ccc",15));
        users.add(new User("zzz",22));
        System.out.println(users);
    }
}
