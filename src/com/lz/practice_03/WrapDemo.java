package com.lz.practice_03;

/**
 * 包装类、基本数据类型、String三者的互换
 */
public class WrapDemo {
    public static void main(String[] args) {
        //把基本数据类型转成包装类   装箱
        Integer num1 = new Integer(10);
        Double dou = Double.valueOf(20.0);
        Character character = Character.valueOf('a');
        //建议用这种
        Integer num2 = Integer.valueOf(17);
        //把包装类转成基本数据类型    拆箱
        int val = num2.intValue();
        //这里完成了自动装箱
        Object object = 17;
        Integer integer = 17; //第一步 自动装箱
        Object object2 = integer;//父类接收子类对象
        //把字符串转成基本数据类型  string ---> int
        int num = Integer.parseInt("12345");
        //传入非法数据报错  NumberFormatException
        //int numm = Integer.parseInt("1223wsz");
    }
}
