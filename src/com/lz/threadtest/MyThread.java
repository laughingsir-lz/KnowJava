package com.lz.threadtest;

/**
 * 自定义线程类   继承Threa类
 * 线程的创建和启动方式一
 */
public class MyThread extends Thread{
    //覆写父类的run方法
    @Override
    //run方法是线程的主体方法
    public void run() {
       // System.out.println("这里是自定义的线程run方法");
        for (int i =0 ;i<10000 ;i++){
            System.out.println("MyThread ===>" +i);
        }
    }
}
