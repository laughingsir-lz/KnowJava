package com.lz.listday02.practice10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName HashMapDemo2
 * @Description:
 * @Author: zzz
 **/
public class HashMapDemo2 {
    public static void main(String[] args) {
        String string = "aaaaaAAAAAzzzdddxxxcvbhhhgggttt6666[[[[]}}";
        char[] chars = string.toCharArray();
        //Map的key存储字符，value存储出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        //迭代每一个字符
        for (char ch : chars) {
            //判断map中有没有这个字符
            if(!map.keySet().contains(ch)){
                //没有就put进map中
               map.put(ch,1);
            }else {
                //有的话，就修改value的值 加一
                Integer integer = map.get(ch);
                integer++;
                //重新put，覆盖原来的，达到修改的目的
                map.put(ch,integer);
            }
        }
        //遍历
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key +"--->"+value);
        }

    }
}
