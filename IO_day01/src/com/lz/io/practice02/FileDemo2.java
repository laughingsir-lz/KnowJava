package com.lz.io.practice02;

import java.io.File;

/**
 * @ClassName FileDemo2
 * @Description: 使用递归列出指定目录中所有的子文件
 * @Author: zzz
 **/
public class FileDemo2 {
    public static void main(String[] args) {
        File file1 = new File("D:/DevelopmentTool/PuTTY");
        list(file1);
    }
    /**
     * 文件的递归遍历方法
     * @param file
     */
    public static void list(File file ){
        //如果file是一个文件夹
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            if (fs!=null){
                for (File f : fs) {
                    //在方法调用自己 递归
                    list(f);
                }
            }
        }
        System.out.println(file);
    }
}
