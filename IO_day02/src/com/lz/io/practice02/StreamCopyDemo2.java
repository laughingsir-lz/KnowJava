package com.lz.io.practice02;

import java.io.*;
/**
 * @ClassName StreamCopyDemo2
 * @Description: 文件拷贝案例-拷贝指定目录的指定类型文件到指定目录
 * @Author: zzz
 **/
public class StreamCopyDemo2 {
    public static void main(String[] args) throws IOException {
        //已知源文件路径
        File file = new File("D:/ABA");
        //创建指定目标文件路径
        String filePath = "D:/BAB/";
        //创建指定文件类型
        String type = ".txt";
        //String type = ".rar";
        //判断是否一个文件夹
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            //遍历文件
            for (File file1 : files) {
                //取出指定类型的文件
                if (file1.getName().endsWith(type)) {
                    //文件复制
                    copy(file1.getPath(), filePath+file1.getName());
                }
            }
        }
    }
    /**
     * 文件复制方法
     * 可以满足任何场景
     * 在有中文字符的情况下 需要自定义乱码解决方案
     * @param srcPath
     * @param destPath
     * @throws IOException
     */
    public static void copy(String srcPath, String destPath) throws IOException {
        //创建Io流对象
        FileInputStream in = new FileInputStream(srcPath);
        FileOutputStream out = new FileOutputStream(destPath);
        //具体的IO操作
        int len = -1;
        //每一次读取1024个字节
        byte[] buff = new byte[1024];
        //先读取一次
        len = in.read(buff);
        while (len > 0) {
            //边读边写
            out.write(buff, 0, len);
            //再继续读取
            len = in.read();
        }
        //关闭资源
        in.close();
        out.close();
    }
}
