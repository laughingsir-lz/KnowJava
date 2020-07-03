package com.lz.learnning.Demo;

/**
 * @ClassName TestDemo1
 * @Description: 单例练习 饿汉式
 * @Author: zzz
 **/
public class TestDemo1 {
    private TestDemo1(){}
    private static TestDemo1 testDemo1 = new TestDemo1();
    static TestDemo1 getInstance(){
        return testDemo1;
    }
    public void get(){
        System.out.println("单例小王子");
    }
}
