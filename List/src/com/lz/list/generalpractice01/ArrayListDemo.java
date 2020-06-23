package com.lz.list.generalpractice01;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArrayListDemo
 * @Description: ArrayList测试
 * @Author: zzz
 **/
public class ArrayListDemo {
    public static void main(String[] args) {
        //创建5个Point对象 指定泛型类型Double
        //钻石语法  前有后无   指定泛型类型
        Point<Double> point1 = new Point<>(1.0,1.0);
        Point<Double> point2 = new Point<>(2.0,2.0);
        Point<Double> point3 = new Point<>(6.0,6.0);
        Point<Double> point4 = new Point<>(4.0,4.0);
        Point<Double> point5 = new Point<>(5.0,5.0);
        //创建ArrayList集合
        List<Point<Double>> list = new ArrayList<>();
        list.add(point1);
        list.add(point2);
        list.add(point3);
        list.add(point4);
        list.add(point5);
        System.out.println(list);
        //删除索引为2的点对象
        list.remove(2);
        System.out.println(list);
        //再把list合集中索引为3的点对象修改成坐标X=3,Y=3的点对象
        list.set(3,new Point<Double>(3.0,3.0));
        System.out.println(list);
    }
}
