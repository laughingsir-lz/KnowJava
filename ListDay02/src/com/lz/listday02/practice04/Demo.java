package com.lz.listday02.practice04;

import java.util.HashSet;

/**
 * @ClassName Demo
 * @Description: Hashset去重测试类
 * @Author: zzz
 **/
public class Demo {
    public static void main(String[] args) {

        HashSet<User> set = new HashSet<>();
        for (int i = 0; i <10; i++) {
            User user = new User("xxx");
            System.out.println(user.hashCode());
            set.add(user);
        }
        System.out.println(set);
    }
}
