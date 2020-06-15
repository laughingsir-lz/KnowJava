package com.lz.threadtest;

/**
 * 多线程并发访问   吃苹果案例
 * 实现接口方式
 * 不同步
 */
public class Apple implements Runnable {
    private int num = 50;//苹果总数
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (num>0){
                System.out.println(Thread.currentThread()+"吃了编号为："+ num-- +"的苹果");
            }
        }
    }
}
