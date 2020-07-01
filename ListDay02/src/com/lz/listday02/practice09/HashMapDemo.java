package com.lz.listday02.practice09;

import java.rmi.MarshalledObject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName HashMapDemo
 * @Description: map的迭代遍历
 * @Author: zzz
 **/
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>(4);
        map.put("xx1","xx1");
        map.put("xx2","xx2");
        map.put("xx3","xx3");
        map.put("xx4","xx4");
        System.out.println(map);
        //获取Map中所有的key
        Set<String> keys = map.keySet();
        System.out.println("map中所有key："+keys);
        //获取Map中所有的values
        Collection<String> values = map.values();
        System.out.println("map中所有的values"+values);
        //获取Map中所有的key——value 键值对
        Set<Map.Entry<String,String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value =entry.getValue();
            System.out.println(key+"->"+value);
        }
    }
}
