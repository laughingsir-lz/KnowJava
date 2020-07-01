package com.lz.io.gengeralpractice01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @ClassName Demo
 * @Description: 使用文件字节输入流 完成读操作
 * @Author: zzz
 **/
public class Demo {
    public static void main(String[] args) throws IOException {
        //要获取文件内容 输入流 从文件到程序
        //创建目标源文件  "QQQAAAZZZWWWSSSXXXEEEDDDCCCBBBBFFFFRRRRVVV"
        File file = new File("D:/ABA/calcCharNum.txt");
        //使用文件字节输入流
        FileInputStream input = new FileInputStream(file);
        byte[] buff = new byte[50];
        //完成文件读取
        System.out.println(input.read(buff));
        System.out.println(Arrays.toString(buff));
        Map<Character,Integer> map = new HashMap<>();
        for (byte b : buff) {
            if (b!=0){
                if(map.get((char)b) == null){
                    map.put((char) b,1);
                }else{
                    map.put((char)b,map.get((char)b)+1);
                }
               }else {
                input.close();
                break;
            }
        }
        System.out.println(map);
        //遍历Map集合并按照以下格式打印，格式如下：“A(2),B(5),C(4),D(6),E(3),F(7)”
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            sb.append(key+"("+value+"),");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }
}
