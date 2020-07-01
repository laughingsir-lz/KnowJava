package com.lz.listday02.generalpractice01;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName PointSetDemo
 * @Description:
 * @Author: zzz
 **/
public class PointSetDemo {
    public static void main(String[] args) {
        Point<Integer> point1 = new Point<>(1,1);
        Point<Integer> point2 = new Point<>(2,2);
        Point<Integer> point3 = new Point<>(3,3);
        Point<Integer> point4 = new Point<>(4,4);
        Point<Integer> point5 = new Point<>(5,5);
       // Point<Integer> point6 = new Point<>(5,5);
        Set<Point<Integer>> pointSet = new HashSet<>();
        pointSet.add(point1);
        pointSet.add(point2);
        pointSet.add(point3);
        pointSet.add(point4);
        pointSet.add(point5);
       // pointSet.add(point6);
        System.out.println(pointSet);
        //set 无序的 不重复的
        //不记录存储顺序 没有索引
        Iterator<Point<Integer>> iterator = pointSet.iterator();
        while (iterator.hasNext()){
            Point<Integer> next = iterator.next();
            System.out.println(next);
        }
    }
}
