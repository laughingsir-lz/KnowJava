package com.lz.list.practice07;

import jdk.nashorn.internal.ir.LiteralNode;

import javax.imageio.metadata.IIOInvalidTreeException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArrayListDemo3
 * @Description: 掌握泛型类的基本使用
 * @Author: zzz
 **/
public class ArrayListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list.add("第一");
        list.add("第二");
        list.add("第三");
        list.add("第四");
        System.out.println(list);
        list1.add(123);
        list1.add(123);
        list1.add(123);
        list1.add(123);
        System.out.println(list1);
        //查询
        System.out.println(list.get(2));
        //删除
        list.remove(3);
        System.out.println(list);
        //修改
        list.set(2,"修改一下");
        System.out.println(list);

    }
}
