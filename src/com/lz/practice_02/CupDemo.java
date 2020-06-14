package com.lz.practice_02;

import static javafx.scene.input.KeyCode.T;

public class CupDemo {
    public static void main(String[] args) {
        Cup c0 = new Cup("白色", 15);
        System.out.println(c0);
        Cup c1 = new TeaCup("红色", 5);
        System.out.println(c1);
        Cup c2 = new CoffeeCup("黑色", 10);
        System.out.println(c2);
        TeaCup cup = new TeaCup("黄色", 3);
        System.out.println(cup);
    }
}
