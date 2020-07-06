package com.lz.jdbc.test;

import org.junit.Test;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName LambdaTest
 * @Description:
 * @Author: zzz
 **/
public class LambdaTest {
    @Test
    public void testLamFiler(){
        List<String> strList= new ArrayList<>();
        strList.add("asdf");
        strList.add("asdfssf");
        strList.add("a");
        strList.add("af");
        List<String> filtered = strList.stream().filter(x -> !x.contains("f")).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
        System.out.printf("Original List : %d, filtered list : %d %n", 1, 20);
    }
    @Test
    public void testList(){
        String[] strings = new String[]{"qwe","asdf","zcvv","jkl"};
        List<String> strList= new ArrayList<>();
        strList.add("asdf");
        strList.add("asdfssf");
        strList.add("a");
        strList.add("af");
        Map<String ,String> map = new HashMap<>();
        map.put("a","b");
        map.put("ad","b");
        map.put("ac","b");
       strList.forEach(s -> {if (s.contains("a")){
           System.out.println("aaaaa");
       }});
      // strList.forEach(System.out::println);
      // map.forEach((key,value)-> System.out.println(key+"->"+value));
      // map.forEach((key,value)->System.out.printf("key : %s \n",key));
    }
}
