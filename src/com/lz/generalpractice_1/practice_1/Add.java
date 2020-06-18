package com.lz.generalpractice_1.practice_1;

/**
 * 加法实现接口
 */
public class Add implements Computer{
    public Add(){}
    @Override
    public int compute(int n, int m) {
        return n+m;
    }
}
