package com.lz.listday02.practice02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ListDemo2
 * @Description: 演示List中的并发修改异常
 * 迭代器迭代只能使用迭代器的remove方法
 * 集合遍历只能使用集合的remove方法
 * @Author: zzz
 **/
public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("你好");
        list.add("hello");
        list.add("hai");
        list.add("拜");
        System.out.println(list);
        //在for-each中删除
//        for (String s : list) {
//            list.remove(s);
//        }
        System.out.println(list);
        //for循环 遍历删除
//        for (int i = 0; i <list.size(); i++) {
//            list.remove(i);
//        }
//        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            iterator.remove();
        }
        System.out.println(list);
    }
}
