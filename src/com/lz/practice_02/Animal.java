package com.lz.practice_02;

/**
 * 动物类   Person类和Monkey类的父类
 */
public class Animal {
    private String name;//名称
    //父类的eat()方法
    public String eat(){
        return "吃东西";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+eat();

    }
}
