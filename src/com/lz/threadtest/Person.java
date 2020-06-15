package com.lz.threadtest;

/**
 * 多线程并发访问案例    吃苹果
 * 继承方式
 * 不同步
 */
public class Person extends  Thread {
    private  int num = 50; //苹果总数

    @Override
    public void run() {
        for (int i = 0;i<50;i++) {
            if (num>0){
                System.out.println(super.getName()+"吃了编号为："+ num-- +"的苹果");
            }
        }
    }

    public Person(String name){
         super(name);
     }
}
