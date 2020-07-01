package com.lz.listday02.practice02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ListDemo1
 * @Description: 演示List中的并发修改异常
 * 迭代器迭代只能使用迭代器的remove方法
 * 集合遍历只能使用集合的remove方法
 * @Author: zzz
 **/
public class ListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("西施");
        list.add("王昭君");
        list.add("貂蝉");
        list.add("杨玉环");
        System.out.println(list);
        //在for-each中删除
//        for (String s : list) {
//            if ("王昭君".equals(s)) {
//                list.remove(s);
//            }
//        }
//        System.out.println(list);
        //for循环 遍历删除
//        for (int i = 0; i <list.size(); i++) {
//            list.remove(i);
//        }
//        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("王昭君".equals(next)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}

