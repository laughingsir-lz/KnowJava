package com.lz.io.practice03;

import java.io.*;

/**
 * @ClassName StreamCopyDemo
 * @Description: 使用文件字符流进行文件拷贝
 * @Author: zzz
 **/
public class StreamCopyDemo {
    public static void main(String[] args) throws IOException {
        //创建源或者目标文件
        File src = new File("D:/ABA/article.txt");
        File dest = new File("D:/ABA/result.txt");
        //创建Io流对对象
        FileReader reader = new FileReader(src);
        FileWriter writer = new FileWriter(dest);
        //具体的IO操作
        int len = -1;
        //每一次读取1024个字符
        char[] buff = new char[1024];
        //先读取一次
        len = reader.read(buff);
        while (len > 0) {
            //边读边写
            writer.write(buff, 0, len);
            //再继续读取
            len = reader.read();
        }
        //关闭资源
        reader.close();
        writer.close();
    }
}