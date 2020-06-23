package com.lz.list.practice05;

import java.util.LinkedList;

/**
 * @ClassName LinkedListDemo
 * @Description: 练习LinkedList类的常用方法
 * @Author: zzz
 **/
public class LinkedListDemo {
    public static void main(String[] args) {
        //创建linkedList对象
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList);
        //将指定元素插入此列表的开头
        linkedList.addFirst("第一次插入表的开头");
        System.out.println(linkedList);
        linkedList.addFirst("第二次插入表的开头");
        System.out.println(linkedList);
        //将指定元素添加到此列表的结尾
        linkedList.addLast("第一次插入表的结尾");
        System.out.println(linkedList);
        // 返回此列表的第一个元素
        System.out.println(linkedList.getFirst());
        //返回此列表的最后一个元素
        System.out.println(linkedList.getLast());
        // 移除此列表的第一个元素，并返回这个元素
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);
        //移除此列表的最后一个元素，并返回这个元素
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);
    }
}
