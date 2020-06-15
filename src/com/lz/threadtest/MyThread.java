package com.lz.threadtest;

/**
 * 自定义线程类   继承Threa类
 * 线程的创建和启动方式一
 */
public class MyThread extends Thread{
    //覆写父类的run方法
    @Override
    public void run() {
        System.out.println("这里是自定义的线程run方法");
    }
}
