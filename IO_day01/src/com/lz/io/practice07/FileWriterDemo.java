package com.lz.io.practice07;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName FileWriterDemo
 * @Description: 演示字符文件输出流(FileWriter)-输出操作
 * @Author: zzz
 **/
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建目标源文件
        File file  =new File("D:/ABA/IoTest.txt");
        //创建IO流对象
        FileWriter writer = new FileWriter(file);
        //具体的IO操作
        writer.write("字符文件输出流字符串输入测试");
        writer.write('Z');
        writer.write('x');
        String string = "从里寻他千百度";
        writer.write(string.toCharArray());
        //关流
        writer.close();
    }
}
