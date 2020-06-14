package com.lz.practice_02;

import javax.swing.*;

/**
 * 鸟类
 */
public class Bird {
    private String leg;//腿
    public Bird() {
        this.leg = "腿 ：2只";
    }
    //鸟类的lay()方法
    public void lay() {
        System.out.println("下蛋");
    }

    @Override
    public String toString() {
        return
                "  leg=" + leg
                ;
    }
}
