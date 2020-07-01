package com.lz.listday02.practice11;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ArrayListDemo
 * @Description: 调用Arrays的常用方法
 * @Author: zzz
 **/
public class ArraysDemo {
    public static void main(String[] args) {
        //把Integer[] 转换为List<Integer>
        List<Integer> list1 = Arrays.asList(1,2,3);
        System.out.println(list1);
        //把String[] 转换为List<String>
        List<String> list2 = Arrays.asList("A","B","C");
        System.out.println(list2);
    }

}
