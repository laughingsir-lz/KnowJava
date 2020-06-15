package com.lz.collectiontest;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 集合的遍历
 */
public class TraverseDemo {
    public static void main(String[] args) {
        //创建集合
        List<String> list = new ArrayList();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        list.add("55");
        System.out.println(list.size());
        System.out.println(list);

        //for循环遍历
        for (int index = 0; index <list.size(); index++) {
            System.out.println(list.get(index));
        }
        System.out.println("---------for-----------");
        //迭代器遍历
        Iterator<String> iterator =list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---------迭代器-----------");

        //for-each  增强for循环
        for (String ele:list) {
            System.out.println(ele);
        }
        System.out.println("---------for-each-----------");
    }
}
