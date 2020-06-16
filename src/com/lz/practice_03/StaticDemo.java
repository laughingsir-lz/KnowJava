package com.lz.practice_03;

/**
 * 数组工具类测试Demo
 */
public class StaticDemo {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        Integer[] arr2 = {12,52,23,15,1,25,40};
        String[] str ={"it","is","a","wolf"};
        //工具类.方法（）   完成调用
        //排序
        ArrayUtil.sort(arr2);
        ArrayUtil.sort(arr);
        //打印
        ArrayUtil.printS(arr);
        ArrayUtil.printS(arr2);
        ArrayUtil.printS(str);
    }


}
