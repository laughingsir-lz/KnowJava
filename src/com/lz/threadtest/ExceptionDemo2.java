package com.lz.threadtest;

/**
 * 线程测试类
 *
 */
public class ExceptionDemo2 {
    public static void main(String[] args) {
    MyRunnable myRunnable = new MyRunnable();
    Thread thread  = new Thread(myRunnable);
    thread.start();
    }
}
