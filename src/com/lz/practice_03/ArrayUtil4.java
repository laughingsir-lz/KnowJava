package com.lz.practice_03;

import java.util.Arrays;

/**
 * 单例设计模式 singleton    懒汉式
 * 最简单，最常用的
 */
public class ArrayUtil4 {
    private static ArrayUtil4 instance;
    //私有化自身构造器
    private ArrayUtil4() {
    }
    //返回自身对象的静态方法
    public static ArrayUtil4 getInstance() {
        if (instance == null) {
            instance = new ArrayUtil4();
        }
        return instance;
    }
    //具体提供的公共静态方法
    //数组排序的公共方法
    public static void sort(Object[] arr) {
        Arrays.sort(arr);
        printS(arr);
    }
    //数组打印的公共方法
    public static void printS(Object[] arr) {
        String string = "[";
        for (int i = 0; i < arr.length; i++) {
            string += arr[i] + ",";
            if (i == arr.length - 1) {
                string += "]";
            }
        }
        System.out.println(string);
        System.out.println("---------打印完毕------------");
    }
}
