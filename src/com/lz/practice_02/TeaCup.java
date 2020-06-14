package com.lz.practice_02;

/**
 * 茶杯类  杯类的子类
 */
public class TeaCup extends Cup {
    public TeaCup() {
    }
    public TeaCup(String color, int capacity) {
        super(color, capacity);
    }
    //覆写父类中的room()方法
    @Override
    public String room() {
       return "装茶";
    }
}
