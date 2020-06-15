package com.lz.threadtest;

/**
 * 吃苹果线程测试类
 * 继承方式 实现多线程  不能共享同一个资源
 * 三个人一共吃了150个苹果
 * 对苹果资源，每个人分别访问50次
 */
public class ExceptionDemo3 {
    public static void main(String[] args) {
        //创建三个线程吃苹果
        new Person("小明").start();
        new Person("小红").start();
        new Person("小花").start();

    }
}
