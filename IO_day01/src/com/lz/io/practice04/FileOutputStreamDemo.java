package com.lz.io.practice04;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName FileOutputStreamDemo
 * @Description: 使用文件字节输出流进行输出操作
 *               从程序到文件就是输出流
 *               write（）方法
 * @Author: zzz
 **/
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建源或者目标对象
        File file  =new File("D:/ABA/IoTest.txt");
        //创建IO流对象
        FileOutputStream outputStream = new FileOutputStream(file);
        //具体的Io操作
        outputStream.write(65);
        outputStream.write(66);
        outputStream.write(67);
        outputStream.write(68);
        //调用一次write方法，光标后移一次
        String string  = " I am a wolf!";
        //输出字符串所有内容
        outputStream.write(string.getBytes());
        //关闭流资源 这是流操作的必做步骤
        outputStream.close();
    }

}
