package com.lz.listday02.practice01;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ListDemo
 * @Description: 演示List迭代的三种方式
 * @Author: zzz
 **/
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("你好");
        list.add("hello");
        list.add("hai");
        list.add("拜");
        System.out.println(list);
        //for循环遍历
        for (int i = 0; i <list.size() ; i++) {
            String string = list.get(i);
            System.out.println(string);
        }

        //for-each 遍历
        for (String s : list) {
            System.out.println(s);
        }

        //迭代器遍历
        Iterator<String> iterable = list.iterator();
        while (iterable.hasNext()){
            String s = iterable.next();
            System.out.println(s);
        }

    }
}
