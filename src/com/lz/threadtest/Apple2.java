package com.lz.threadtest;

/**
 * 多线程并发访问   吃苹果案例
 * 实现接口方式
 * 不同步       同步方法解决同步问题
 */
public class Apple2 implements Runnable {
    private int num = 50;//苹果总数

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            this.eat();
        }
    }

    //同步方法  synchronized 修饰
    private synchronized void eat() {
        try {
            for (int i = 0; i < 50; i++) {
                if (num > 0) {
                    Thread.sleep(10); //放大线程的不安全 便于观察
                    System.out.println(Thread.currentThread() + "吃了编号为：" + num-- + "的苹果");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
