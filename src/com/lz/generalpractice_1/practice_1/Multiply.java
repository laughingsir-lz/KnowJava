package com.lz.generalpractice_1.practice_1;

/**
 * 乘法实现接口
 */
public class Multiply implements Computer {
    @Override
    public int compute(int n, int m) {
        return n*m;
    }
}
