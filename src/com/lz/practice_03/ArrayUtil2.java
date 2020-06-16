package com.lz.practice_03;

import java.util.Arrays;

/**
 * 单例设计模式 singleton    饿汉式
 * 最简单，最常用的
 */
public class ArrayUtil2 {
    //单例三步曲
    //私有化自身构造器
    private ArrayUtil2(){}
    //创建自身对象
     private static ArrayUtil2 arrayUtil2  = new ArrayUtil2();
    //向外暴露一个公共的静态方法用于返回自身的对象
    public static ArrayUtil2 getArrayUtil2(){
        return  arrayUtil2;
    }
    //具体提供的公共静态方法
    //数组排序的公共方法
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
