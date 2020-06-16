package com.lz.practice_03;

/**
 * split()方法的使用
 */
public class ItemDemo {
    public static void main(String[] args) {
        Item item = new Item();
        String text = "name：移动硬盘；price：58.0";
        String[] strings = text.split("；");
        for (int i = 0; i < strings.length; i++) {
            //String[] strings1 = strings[i].split("：");
            System.out.println(strings[i]);
            if (strings[i].contains("name")) {
                item.setName(strings[i].substring(5));
            }else {
                item.setPrice(Double.parseDouble(strings[i].substring(6)));
            }
        }
        System.out.println(item);
    }
}
