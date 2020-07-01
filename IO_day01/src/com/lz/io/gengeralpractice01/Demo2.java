package com.lz.io.gengeralpractice01;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Demo2
 * @Description: 使用文件字符输入流 完成读操作
 * @Author: zzz
 **/
public class Demo2 {
    public static void main(String[] args) throws IOException {
        //创建目标源文件
        File file = new File("D:/ABA/calcCharNum.txt");
        //存储map
        Map<Character,Integer> map = new HashMap<>();
        //使用文件字符输入流 完成读操作
        //创建文件字符流对象
        FileReader reader = new FileReader(file);
        //创建字符缓冲数组
        char[] buff =new char[45];
        int len =reader.read(buff);
        System.out.println(buff.toString());
        //完成map的生成
        for (int i = 0; i <len ; i++) {
            if (map.containsKey(buff[i])){
                map.put(buff[i],map.get(buff[i])+1);
            }else {
                map.put(buff[i],1);
            }
        }
        System.out.println(map);
        //遍历Map集合并按照以下格式打印，格式如下：“A(2),B(5),C(4),D(6),E(3),F(7)”
        StringBuilder sb = new StringBuilder();
        int count =0;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                count++;
                if (count!=map.size()){
                    sb.append(key+"("+value+"),");
                }else {
                    sb.append(key+"("+value+")");
                }
            }
        System.out.println(sb.toString());
        reader.close();
    }
}
