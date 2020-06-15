package com.lz.collectiontest;


import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        //创建默认长度的列表对象
        List list = new ArrayList();
        System.out.println(list.size());
        //添加
        list.add("will");
        list.add("is");
        list.add("a");
        list.add("wolf");
        //查询
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(1));
        //修改
        list.set(3, "wolfcode");
        System.out.println(list.get(3));
        //删除
        list.remove(1);
        System.out.println(list);

    }
}
