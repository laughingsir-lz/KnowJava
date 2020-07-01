package com.lz.io.practice04;

import java.io.*;

/**
 * @ClassName BufferedDemo
 * @Description:
 * @Author: zzz
 **/
public class BufferedDemo {
    public static void main(String[] args) throws IOException {
        //已知源文件路径
        File file = new File("D:/ABA");
        //创建指定目标文件路径
        String filePath = "D:/BAB/";
        //创建指定文件类型
        //String type = ".txt";
        String type = ".rar";
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
    public static void copy(String srcPath,String destPath) throws IOException {
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(destPath));
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(srcPath));
        byte[] bytes = new byte[1024];
        int len = bi.read(bytes);
        while(len!=-1){
            //手动刷新 把缓冲区里的数据写出去
            bo.flush();
            //写操作 ；边读边写 读多少，写多少
            bo.write(bytes,0,len);
            //读操作
            len =bi.read(bytes);
        }
        bi.close();
        bo.close();
    }
}
