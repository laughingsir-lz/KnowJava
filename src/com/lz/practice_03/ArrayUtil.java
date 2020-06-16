package com.lz.practice_03;

import java.util.Arrays;

/**
 **用static方法
 * 公共静态方法
 * 数组工具类
 */
public class ArrayUtil {
    private ArrayUtil(){
    }
    //数组排序的公共方法
    public static void  sort(Object[] arr){
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
