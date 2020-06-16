package com.lz.practice_03;

import java.util.Arrays;

/**
 * 单例设计模式 singleton
 * 最简单实现  枚举
 */
public enum ArrayUtil3 {
    INSTANCE;
    public static void sort(Object[] arr){
        Arrays.sort(arr);
        printS(arr);
    }
    //数组打印的公共方法
    public static void printS(Object[] arr){
        String string="[";
        for (int i = 0; i <arr.length ; i++) {
            string += arr[i]+",";
            if (i==arr.length-1){
                string += "]";
            }
        }
        System.out.println(string);
        System.out.println("---------打印完毕------------");
    }
}
