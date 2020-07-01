package com.lz.io.gengeralpractice01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Demo3
 * @Description:
 * @Author: zzz
 **/
public class Demo3 {
    public static void main(String[] args) throws IOException {
        //创建目标源文件
        File file = new File("D:/ABA/calcCharNum.txt");
        //存储map
        Map<Character,Integer> map = new HashMap<>();
        //使用文件字符输入流 完成读操作
        //创建文件字符流对象
        FileReader reader = new FileReader(file);
        StringBuilder stringBuilder = new StringBuilder();
        int count = reader.read();
        while(count!=-1){
            stringBuilder.append((char)count);
            if(map.get((char)count)==null){
                map.put((char) count,1);
            }else {
                map.put((char) count,map.get((char)count)+1);
            }
            count = reader.read();
        }
        System.out.println(stringBuilder);
        //遍历Map集合并按照以下格式打印，格式如下：“A(2),B(5),C(4),D(6),E(3),F(7)”
        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        int i =0;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            i++;
            if (i!=map.size()){
                sb.append(entry.getKey()+"("+entry.getValue()+"),");
            }else {
                sb.append(entry.getKey()+"("+entry.getValue()+")");
            }
        }
        System.out.println(sb.toString());
        reader.close();
    }
}
