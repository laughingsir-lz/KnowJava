package com.lz.practice_02;

/**
 * Monkey类    Animal类的子类
 */
public class Monkey extends Animal {
    //覆写父类中的eat()方法
    @Override
    public String eat() {
        return "吃香蕉";
    }
}
