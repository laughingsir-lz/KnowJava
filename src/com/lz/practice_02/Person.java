package com.lz.practice_02;

/**
 * Person 类  Animal 类的子类
 */
public class Person extends Animal {
    //覆写父类中eat()方法
    @Override
    public String eat() {
        return "吃稀饭";
    }
}
