package com.lz.practice_02;

/**
 * 昆虫类
 */
public class Insect {
    private String leg;//腿
    public Insect() {
        this.leg = "腿 ：6只";
    }
    //昆虫类的lay()方法
    public void lay(){
        System.out.println("产卵");
    }
    @Override
    public String toString() {
        return "  leg=" + leg;
    }
}
