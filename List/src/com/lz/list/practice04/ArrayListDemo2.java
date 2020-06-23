package com.lz.list.practice04;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArrayListDemo2
 * @Description: list 内存分析图
 * @Author: zzz
 **/
public class ArrayListDemo2 {
    public static void main(String[] args) {
        User user1 = new User("用户1",16);
        System.out.println(user1);
        User user2 = new User("用户2",17);
        System.out.println(user2);
        User user3 = new User("用户3",18);
        User user4 = new User("用户4",19);
        List list = new ArrayList();
        System.out.println(list);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        System.out.println(list);
    }
}
