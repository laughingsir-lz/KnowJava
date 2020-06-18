package com.lz.practice_03;


/**
 * split()方法的使用
 * 需要多个item对象的处理方式
 */
public class ItemDemo2 {
    public static void main(String[] args) {
        Item item = new Item();
        String text = "name：移动硬盘；price：58.0；name：笔记本；price：4500.0；name：手机；price：1999.9";
        String string1 = text.replaceAll("[a-zA-Z]*[：]", "");
        String[] ss = string1.split("；");
        for (int i = 0; i < ss.length; i += 2) {
            item.setName(ss[i]);
            item.setPrice(Double.parseDouble(ss[i + 1]));
            System.out.println(item);
        }
    }
}
