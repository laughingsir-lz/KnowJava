package com.lz.practice_03;

/**
 * String中的常用方法的调用（12个）
 */
        public class StringDemo {
            public static void main(String[] args) {
                //直接赋值一个string
                String string = "it is a wolf";
                //构造器创建string1
                String string1 = new String("春哥");
                //返回字符串长度
        System.out.println(string.length());
        //返回指定索引位置的字符
        System.out.println(string.charAt(3));
        //返回第一次出现指定字符的索引位置  可以做字符存在的判断
        System.out.println(string.indexOf('a'));
        //比较字符串内容是否相等
        System.out.println(string.equals("it is a wolf"));
        //忽略大小写 比较内容是否相等
        System.out.println(string.equalsIgnoreCase("It Is A wOlf"));
        //把字符串转换为大写
        System.out.println(string.toUpperCase());
        //把字符串转换为小写
        System.out.println(string.toUpperCase().toLowerCase());
        //从指定索引位置开始截取字符串
        System.out.println(string.substring(3));
        //从指定区间截取字符串
        System.out.println(string.substring(3, 5));
        //判断是否包含指定的子字符串
        System.out.println(string.contains("is"));
        //按照指定的空格符分割字符串
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        //去掉字符串中的空格符
        System.out.println(string.trim());
    }
}
