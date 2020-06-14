package com.lz.practice_02;

/**
 * 咖啡杯 杯的子类
 */
public class CoffeeCup extends Cup {
    public CoffeeCup() {
    }
    public CoffeeCup(String color, int capacity) {
        super(color, capacity);//父类构造器
    }
    //覆写父类room()方法
    @Override
    public String room() {
       return "装咖啡";
    }
}
