package com.lz.practice_03;

/**
 * 模拟int类型的包装类实现
 * 增强对int类型的值做操作的功能
 */
public class IntWrapper {
    private  int value;
    public IntWrapper(){}

    public int getValue() {
        return value;
    }

    public IntWrapper(int value){
        this.value = value;

    }
}
