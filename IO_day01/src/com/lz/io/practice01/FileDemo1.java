package com.lz.io.practice01;

import java.io.File;

/**
 * @ClassName FileDemo1
 * @Description: 演示File类分隔符  了解File类中的字段，最终使用”/”
 * @Author: zzz
 **/
public class FileDemo1 {
    public static void main(String[] args) {
        //路径中的分隔符/和\\,"\\" \是转义字符
        File file = new File("D:\\ABA\\IoTest.txt");
        //推荐使用这一种
        File file1 = new File("D:/ABA/IoTest.txt");
        //获取文件名称
        System.out.println(file.getName());
        System.out.println(file1.getName());
        //获取文件路径
        System.out.println(file1.getPath());
        //获取绝对路径
        System.out.println(file.getAbsolutePath());
        System.out.println(file1.getAbsoluteFile());
        //获取上级目录
        System.out.println(file1.getParentFile());
        //判断文件是否存在
        System.out.println(file.exists());
        //判断文件是否时目录
        System.out.println(file.isDirectory());
        //判断是否是一个文件
        System.out.println(file.isFile());
        //判读是否隐藏
        System.out.println(file.isHidden());
        //删除文件
        //file.delete();
        //列出当前文件夹中所有文件
        File[] fs = file.getParentFile().listFiles();
        for (File f : fs) {
            System.out.println(f);

        }
    }

}
