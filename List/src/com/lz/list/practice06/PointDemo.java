package com.lz.list.practice06;

/**
 * @ClassName PointDemo
 * @Description: 泛型测试
 * @Author: zzz
 **/
public class PointDemo {
    public static void main(String[] args) {
        Point point  =new Point();
        Object x1 =point.getX();
        //使用String作为泛型
        Point<String> point1 =new Point<String>();
        String x2 = point1.getX();
        //使用Integer作为泛型
        Point<Integer> point2 = new Point<Integer>();
        Integer x3 = point2.getX();
        Integer y3 = point2.getY();
        //泛型创建左右一致
        //左边必写，右边可省
        Point<Double> point3 = new Point<Double>();
        Point<Double> point4 = new Point<>();
    }
}
