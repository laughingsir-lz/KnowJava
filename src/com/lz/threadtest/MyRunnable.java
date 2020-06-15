package com.lz.threadtest;

/**
 * 线程实现的第二中方法
 *实现Runnable接口git remote add origin
 */
public class MyRunnable  implements  Runnable{
    @Override
    public void run() {
        System.out.println("这是自定义的Runnable接口的run方法");
    }
}
