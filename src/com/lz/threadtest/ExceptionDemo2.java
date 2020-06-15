package com.lz.threadtest;

/**
 * 线程测试类
 *
 */
public class ExceptionDemo2 {
    public static void main(String[] args) {
        //创建实现类对象
    MyRunnable myRunnable = new MyRunnable();
    //利用线程Thread 实例化线程对象
        //new Thread（myRunnable）
    Thread thread  = new Thread(myRunnable);
    //线程调用start方法
    thread.start();
    }
}
