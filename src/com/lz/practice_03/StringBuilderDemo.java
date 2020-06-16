package com.lz.practice_03;

/**
 * 使用StringBuilder拼接字符串
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        //线程不安全 性能高
        StringBuilder stringBuilder = new StringBuilder();
        //使用append方法在原字符串后面追加字符串   继续拼接
        stringBuilder.append("123").append(456);
        //线程安全 性能低
        StringBuffer ss = new StringBuffer();
        ss.append("123").append(123);
        System.out.println(ss);
    }
}
