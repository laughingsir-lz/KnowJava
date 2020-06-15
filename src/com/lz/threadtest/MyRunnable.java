package com.lz.threadtest;

/**
 * 线程实现的第二种方法
 *实现Runnable接口  该接口只有run方法
 * MyRunnable类是接口Runnable的实现类
 */
public class MyRunnable  implements  Runnable{
    //实现接口中的run方法
    @Override
    public void run() {
        System.out.println("这是自定义的Runnable接口的run方法");
    }
}
