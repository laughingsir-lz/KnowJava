package com.lz.threadtest;

public class MyRunnable  implements  Runnable{
    @Override
    public void run() {
        System.out.println("这是自定义的Runnable接口的run方法");
    }
}
