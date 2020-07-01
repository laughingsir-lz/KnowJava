package com.lz.io.practice01;

import java.io.*;

/**
 * @ClassName StreamCopyDemo
 * @Description: 使用文件字节流进行文件拷贝
 * @Author: zzz
 **/
public class StreamCopyDemo1 {
    public static void main(String[] args) throws IOException {
        //创建源或者目标文件
        File src = new File("D:/ABA/article.txt");
        File dest = new File("D:/ABA/result.txt");
        //创建Io流对对象
        FileInputStream in = new FileInputStream(src);
        FileOutputStream outputStream = new FileOutputStream(dest);
        //具体的IO操作
        int len = -1;
        //每一次读取1024个字符
        byte[] buff = new byte[1024];
        //先读取一次
        len = in.read(buff);
        while (len > 0) {
            //边读边写
            outputStream.write(buff, 0, len);
            //再继续读取
            len = in.read();
        }
        //关闭资源
        in.close();
        outputStream.close();
    }
}
