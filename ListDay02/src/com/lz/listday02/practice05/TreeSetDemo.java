package com.lz.listday02.practice05;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName TreeSetDemo
 * @Description: 演示TreeSet接口中的常用操作
 * @Author: zzz
 **/
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> set1 = new TreeSet<>();
        Set<Character> set2 = new TreeSet<>();
        Set<Integer> set3 = new TreeSet<>();
        //增加
        set1.add("nice");
        set1.add("to");
        set1.add("meet");
        set1.add("you");
        set1.add("中文");
        System.out.println(set1);
        set2.add('N');
        set2.add('B');
        set2.add('A');
        set2.add('!');
        set2.add('\\');
        System.out.println(set2);
        set3.add(100);
        set3.add(101);
        set3.add(10);
        set3.add(10000);
        System.out.println(set3);
        //包含
        System.out.println((set1.contains("you") ? "是" : "否"));
        System.out.println(set1);
        //删除
        set1.remove("you");
        System.out.println((set1.contains("you") ? "是" : "否"));
        System.out.println(set1);
        //迭代器遍历
        Iterator<String> iterator = set1.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
