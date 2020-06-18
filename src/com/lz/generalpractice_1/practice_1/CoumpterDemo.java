package com.lz.generalpractice_1.practice_1;
/**
 * 计算器测试类
 */
public class CoumpterDemo {
    public static void main(String[] args) {
        Computer computer1 = new Add();
        UseCompute.useCom(computer1,2,4);
        Computer computer2 = new Subtract();
        UseCompute.useCom(computer2,2,4);
        Computer computer3 = new Multiply();
        UseCompute.useCom(computer3,2,4);
        Computer computer4 = new Divide();
        UseCompute.useCom(computer4,4,2);
    }
}
