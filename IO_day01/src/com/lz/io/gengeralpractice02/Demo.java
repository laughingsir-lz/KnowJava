package com.lz.io.gengeralpractice02;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Demo
 * @Description:
 * @Author: zzz
 **/
public class Demo {
    public static void main(String[] args) throws IOException {
        //学生对象集合
        List<Student> studentList = new ArrayList<>();
        //总分
        int sum = 0;
        //文件内容
        StringBuilder stringBuilder = new StringBuilder();
        //创建目标源文件
        File file =new File("D:/ABA/info.txt") ;
        //创建文件字符输入流对象
        FileReader reader = new FileReader(file);
        //循环读文件
        int count= reader.read();
        while (count!=-1){
            stringBuilder.append((char)count);
            count = reader.read();
        }
        String s = new String(stringBuilder);
        //切分成学生信息数据段
        String[] strings = s.split(";");
        System.out.println(strings.length);
        System.out.println(Arrays.toString(strings));
        for (int i = 0; i <strings.length ; i++) {
            String[] split = strings[i].split("-");
            //创建学生对象
            Student student = new Student(split[0],Integer.valueOf(split[1]),Integer.valueOf(split[2]));
            //保存学生对象
            studentList.add(student);
            //求总分
            sum += Integer.valueOf(split[2]);
        }
        System.out.println(studentList);
        System.out.println("学生总分："+sum);
        //关流
        reader.close();
    }
}
