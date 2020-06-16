package com.lz.practice_03;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *精确小数解决方案
 * 常用类 BigDecimal
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        double d1 = 20.0;
        double d2 = 12.3;
        System.out.println(d1);
        System.out.println((d1 + d2));
        //double不能表示精确小数
        //输出0.09999999999999999
        System.out.println((0.09 + 0.01));
        //引入BigDecimal
        //使用BigDecimal  double 构造器
        BigDecimal bd1 = new BigDecimal(0.09);
        BigDecimal bd2= new BigDecimal(0.01);
        //输出0.09999999999999999687749774324174723005853593349456787109375
        System.out.println(bd1.add(bd2));
        //使用BigDecimal String 构造器  做到精确数据计算
        BigDecimal bd3 = new BigDecimal("0.01");
        BigDecimal bd4 = new BigDecimal("0.09");
        //输出0.10
        System.out.println(bd3.add(bd4));
        //BigDecimal类中主要是加减乘除
        BigDecimal rest1 = bd1.add(bd2); //加
        System.out.println(rest1);
        BigDecimal rest2 = bd1.subtract(bd2);  //减
        System.out.println(rest2);
        //乘  四舍五入   保留两位小数
        BigDecimal rest3 = bd1.multiply(bd2).setScale(2, RoundingMode.HALF_UP);
        System.out.println(rest3);
        //除 四舍五入   保留两位小数
        BigDecimal rest4 = bd1.divide(bd2,2,RoundingMode.HALF_UP);
        System.out.println(rest4);
        //当除不尽时，除法需要做保留位数的操作，
        BigDecimal num1 = new BigDecimal("1");
        BigDecimal num2 = new BigDecimal("3");
        // setScale()方法是不能使用的
        //System.out.println(num1.divide(num2).setScale(2, RoundingMode.HALF_UP));
        //使用divide(BigDecimal divisor,int scale,int RoundingMode)
        System.out.println(num1.divide(num2, 2, RoundingMode.HALF_UP));



    }
}
