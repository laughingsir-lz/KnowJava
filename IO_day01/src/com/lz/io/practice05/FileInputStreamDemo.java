package com.lz.io.practice05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName FileInputStreamDemo
 * @Description: 使用文件字节输入流进行输入操作
 *                从文件到程序就是输入流
 *                read（）方法
 * @Author: zzz
 **/
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建目标源文件
        File file  =new File("D:/ABA/IoTest.txt");
        //创建Io流对象
        FileInputStream fileInputStream = new FileInputStream(file);
        //具体的IO流操作
        //读取一个字符
        //System.out.println((char)fileInputStream.read());
        //System.out.println((char)fileInputStream.read());
        //System.out.println((char)fileInputStream.read());
       // System.out.println((char)fileInputStream.read());
        //调用一次read方法，在文件中的光标就后移一位
        //准备缓冲去
        byte[] buff = new byte[20];
        //读取字节长度
        int length = fileInputStream.read(buff);
        //将缓冲区里的内容输出
        System.out.println(Arrays.toString(buff));
        //返回读取长度
        System.out.println(length);
        String ret = new String(buff);
        System.out.println(ret);
        //关闭流
        fileInputStream.close();
    }
}
