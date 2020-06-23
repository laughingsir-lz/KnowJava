package com.lz.list.practice02;

import com.lz.list.practice01.PlayList;

import java.util.Arrays;

/**
 * @ClassName MyArrayListDemo
 * @Description: MyArrayList 测试类
 * @Author: zzz
 **/
public class MyArrayListDemo {
    public static void main(String[] args) {
        //创建容器
        MyArrayList myArrayList = new MyArrayList();
        System.out.println(myArrayList);
        //创建各种类型的元素 ,并完成添加
        int[] ints = {1,2,3};
        myArrayList.add(123);
        myArrayList.add("string");
        myArrayList.add(Arrays.toString(ints));
        myArrayList.add(new PlayList());
        System.out.println(myArrayList);
        //查询指定位置元素
        System.out.println(myArrayList.get(2));
        //修改指定位置元素
        myArrayList.set(1,"修改字符串");
        System.out.println(myArrayList.get(1));
        //删除指定位置元素
        myArrayList.remove(2);
        System.out.println(myArrayList);
    }

}
