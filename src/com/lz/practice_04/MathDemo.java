package com.lz.practice_04;

/**
 * 使用Math类常用方法
 */
public class MathDemo {
    public static void main(String[] args) {
        //返回最大值
        System.out.println(Math.max(99, 10));
        //返回最小值
        System.out.println(Math.min(99, 10));
        //返回一个[0,1)之间的随机小数
        double num = Math.random();
        System.out.println(num);
        //返回一个[0，100)之间的随机整数
        int intNum = (int) (num*100);
        System.out.println(intNum);
        //得到任意区间的随机数 在基于random()方法实现时都要转换
        //得到23-104之间的随机数 转换 [0-（104-23）]+23之间
        int intNum2 = (int) (Math.random()*81+23);
        System.out.println(intNum2);
    }
}
