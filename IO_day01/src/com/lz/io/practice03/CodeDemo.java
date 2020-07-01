package com.lz.io.practice03;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @ClassName CodeDemo
 * @Description: 字符解码和编码操作
 * @Author: zzz
 **/
public class CodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //模拟输入内容
        String input = "输入测试 input test ！";
        //编码 由字符--->编码
        //string-->byte[]
        byte[] bytes = input.getBytes();
        //得到编码数组
        System.out.println(Arrays.toString(bytes));
        //解码 由编码--->字符
        String ret = new String(bytes);
        System.out.println(ret);
        //在同一个环境中，未指定字符集，使用默认的，所以以上未出现乱码
        //指定不同环境的字符集
        //编码 字符集UTF-8
        byte[] data = input.getBytes("UTF-8");
        //测试 ISO-8859-1
        byte[] data2 = input.getBytes("ISO-8859-1");
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(data2));
        //解码 对应字符集解码
        String s = new String(data,"ISO-8859-1");
        System.out.println(s);
        String s1 = new String(data,"UTF-8");
        System.out.println(s1);
        String s2 = new String(data2,"ISO-8859-1");
        System.out.println(s2);
        String s3 = new String(data2,"UTF-8");
        System.out.println(s3);
        //编码解码用的字符集不一致时，就会出现乱码
        //中文字符必须选择含中文的字符集编码解码
        //中文乱码是乱码核心问题
        //出现中文字符时，必须做好乱码解决方案
    }
}
