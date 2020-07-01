package com.lz.listday02.generalpractice01;

import java.util.Objects;

/**
 * @ClassName Point
 * @Description:
 * @Author: zzz
 **/
public class Point<T> {
    private T x;
    private T Y;

    public Point() {
    }

    public Point(T x, T y) {
        this.x = x;
        Y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return Y;
    }

    public void setY(T y) {
        Y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", Y=" + Y +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Point<?> point = (Point<?>) o;
//        return Objects.equals(x, point.x) &&
//                Objects.equals(Y, point.Y);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, Y);
//    }
}
