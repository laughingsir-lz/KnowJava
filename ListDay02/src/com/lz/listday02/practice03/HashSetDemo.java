package com.lz.listday02.practice03;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName HashSetDemo
 * @Description: 演示HashSet接口中的常用操作
 * @Author: zzz
 **/
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //添加操作
        set.add("aaa");
        set.add("SSS");
        set.add("ZZZ");
        set.add("xxx");
        //设置一个重复的
        set.add("aaa");
        //查询操作
        System.out.println("集合中的所有元素有："+set);
        System.out.println("集合的大小为 "+set.size());
        System.out.println("集合中是否存在 xxx ："+(set.contains("xxx")?"是":"否"));
        System.out.println(set.contains("ddd")?"是":"否");
        //删除操作：删除code
        set.remove("xxx");
        System.out.println("删除后的集合中的所有元素有："+set);
        //使用for-each遍历 只读 不修改
        for (String s : set) {
            System.out.println(s);
        }
        //使用迭代器遍历
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
