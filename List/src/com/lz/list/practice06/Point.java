package com.lz.list.practice06;

/**
 * @ClassName Point
 * @Description: 点类
 * @Author: zzz
 **/
public class Point<T> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}
