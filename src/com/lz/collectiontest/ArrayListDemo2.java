package com.lz.collectiontest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        User user1 = new User("QQQ",17);
        User user2 = new User("WWW",18);
        User user3 = new User("EEE",19);
        User user4 = new User("AAA",20);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        //修改user1的信息
        user1.setAge(21);
        user1.setName("中文名");
        System.out.println(list);


    }
}
