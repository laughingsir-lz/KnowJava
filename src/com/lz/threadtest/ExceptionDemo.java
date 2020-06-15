package com.lz.threadtest;

/**
 * 线程测试类
 *
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        //创建自定义对象
        MyThread myThread = new MyThread();
        //调用Thread类的start方法，JVM会自动调用run方法
        myThread.start();
    }
}
