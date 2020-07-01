package com.lz.io.practice06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName FileReaderDemo
 * @Description: 演示字符文件输入流(FileReader)-输入操作
 * @Author: zzz
 **/
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        //创建目标源文件
        File file  =new File("D:/ABA/IoTest.txt");
        //创建Io流对象
        FileReader reader = new FileReader(file);
        //具体的io操作
        System.out.println((char)reader.read());
        System.out.println((char)reader.read());
        System.out.println((char)reader.read());
        System.out.println((char)reader.read());
        //字符 char  缓冲区
        char[] buff = new char[30];
        int len = reader.read(buff);
        //打印字符数组
        System.out.println(Arrays.toString(buff));
        System.out.println(len);
        String string = new String(buff) ;
        System.out.println(string);
        //关流
        reader.close();
    }
}
