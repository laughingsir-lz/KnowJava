package com.lz.threadtest;

/**
 * 多线程并发访问   吃苹果案例
 * 实现接口方式
 * 不同步       解决代码同步
 */
public class Apple implements Runnable {
    private int num = 50;//苹果总数

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                //同步代码块解决线程同步
                //synchronized (this){需要同步操作的代码（从性能上讲，这里的代码越少越好）}
                //这里的this就是指Apple对象   this的核心是指代当前对象  谁用指谁
                synchronized (this) {
                    if (num > 0) {
                        Thread.sleep(10); //放大线程的不安全 便于观察
                        System.out.println(Thread.currentThread() + "吃了编号为：" + num-- + "的苹果");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
