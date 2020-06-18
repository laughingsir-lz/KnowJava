package com.lz.generalpractice_1.practice_2;


/**
 * 大小写转换测试类
 */
public class PrintDemo {
    public static void main(String[] args) {
        //创建父类对象 引用子类实例   多态实现
        //创建大写 iU对象
        IUppercaseLetter iU = new PrintImpl();
        iU.printUppercaseLetter();
        //创建小写 iL对象
        ILowercaseLetter iL =new PrintImpl();
        iL.printLowercaseLetter();
    }
}
