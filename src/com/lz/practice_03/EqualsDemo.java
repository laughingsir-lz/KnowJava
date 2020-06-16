package com.lz.practice_03;

/**
 * String类中Equal方法
 * 比较 == 和 equals
 */
public class EqualsDemo {
    public static void main(String[] args) {
        //演示String类创建对象的两种方式
        //直接赋值一个字面量
        String str = null;//引用为空，没有初始化，没有内存空间
        String string = "";//值为空串，已初始化，内存中存""
        String str1 = "ABCD";
        //通过构造器创建   （每一次new 都是开辟一个新的内存空间）
        String str2 = new String("ABCD");
        // 使用 == 和equals方法进行比较
        // ==  比较两者引用地址是否一致
        System.out.println("引用地址是否一致：" + (str1 == str2));
        //equals  比较两者引用对象内容是否一致
        System.out.println("引用对象内容是否一致：" + str1.equals(str2));
        //判断字符串非空
        System.out.println("当前字符串是非空：" + hashLength(str1));
        System.out.println("当前字符串是非空：" + hashLength(string));
        System.out.println(str2);
        System.out.println("当前字符串是非空：" + hashLength(str2));

    }

    /**
     * 判断字符串非空    即不为null也不为"" （空串）
     *trim()方法  去掉字符串中前后的空格
     * str = "     ";  这也是空串
     * @param str
     * @return
     */
    public static boolean hashLength(String str) {
        return str != null && !str.trim().equals("");
    }
}
