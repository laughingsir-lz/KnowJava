package com.lz.list.practice03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ArrayListDemo
 * @Description: 练习ArrayList类的常用方法
 * @Author: zzz
 **/
public class ArrayListDemo {
    public static void main(String[] args) {
        //创建ArrayList对象
        List list = new ArrayList();
        System.out.println("当前元素数量： "+list.size());
        //添加元素  顺序添加 将元素添加到列表末尾
        list.add(list.size()+"元素");
        list.add(list.size()+"元素");
        list.add(list.size()+"元素");
        list.add(list.size()+"元素");
        //打印集合元素
        System.out.println(list);
        System.out.println(list.size());
        //在指定位置插入指定元素
        list.add(2,"指定元素");
        System.out.println(list);
        //创建新集合
        List newList = new ArrayList();
        newList.add(newList.size()+"号元素");
        newList.add(newList.size()+"号元素");
        newList.add(newList.size()+"号元素");
        newList.add(newList.size()+"号元素");
        //将newLIst中的数据添加到集合list中
        //顺序添加
        list.addAll(newList);
        System.out.println(list);
        //将newList中的元素添加到list指定位置
        list.addAll(0,newList);
        System.out.println(list);
        //从列表中删除指定索引位置的元素,并返回被删除的元素
        System.out.println(list.remove(7));
        System.out.println(list);
        //从此列表中移除c列表中的所有元素
        list.removeAll(newList);
        System.out.println(list);
        //修改列表中指定索引位置的元素，返回被替换的旧元素
        System.out.println(list.set(0, "替换元素"));
        System.out.println(list);
        //判断当前列表中元素个数是否为0
        System.out.println(list.isEmpty());
        //查询列表中指定索引位置对应的元素
        System.out.println(list.get(2));
        //把列表对象转换为Object数组
        System.out.println(Arrays.toString(list.toArray()));
        //判断列表是否存在指定对象
        System.out.println(list.contains("指定元素"));


    }

}
