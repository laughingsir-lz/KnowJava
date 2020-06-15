package com.lz.threadtest;

/**
 * 吃苹果线程测试类
 *实现接口方式
 * 接口方式的多线程实现 可以共享同一个资源
 * 三个人一共吃50个苹果
 */
public class ExceptionDemo4 {
    public static void main(String[] args) {
        //创建实现类对象
   Apple apple = new Apple();
    //利用线程Thread 实例化线程对象
        //new Thread（myRunnable）
    //Thread thread  = new Thread(apple);
    //线程调用start方法
    //thread.start();
        new Thread(apple,"明明").start();
        new Thread(apple,"红红").start();
        new Thread(apple,"花花").start();
    }
}
