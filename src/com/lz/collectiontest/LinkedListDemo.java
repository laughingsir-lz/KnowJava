package com.lz.collectiontest;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("AAAAAAAA");
        System.out.println(linkedList);
        linkedList.addFirst("BBBBBBBBB");
        System.out.println(linkedList);
        linkedList.addFirst("CCCCCCC");
        linkedList.addLast("DDDDDDDD");
        linkedList.add("1111111111");
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.add("2222222");
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);
    }
}
