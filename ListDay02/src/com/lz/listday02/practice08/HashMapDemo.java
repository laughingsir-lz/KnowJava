package com.lz.listday02.practice08;

import sun.rmi.runtime.NewThreadAction;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HashMapDemo
 * @Description: 调用HashMap的常用方法
 * @Author: zzz
 **/
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(4);
        HashMap<String, String> map2 = new HashMap<>(4);

        //存储键值对到map中
        map.put("girl1","西施");
        map.put("girl2","杨玉环");
        map.put("girl3","王昭君");
        map.put("girl4","貂蝉");
        System.out.println(map);
        System.out.println("map中的键值对有 "+map.size());
        map2.put("girl5","路人甲");
        map2.put("girl6","路人乙");
        map2.put("girl7","路人丙");
        //把m中的所有键值对添加到当前Map中
        map.putAll(map2);
        System.out.println(map);
        //通过存储相同key覆盖原来的值，完成修改数据的操作
        map.put("girl5","修改甲");
        System.out.println(map);
        //从Map中删除指定key的键值对，并返回被删除key对应的value
        System.out.println("对象 ："+map.remove("girl5")+" 已被删除");
        System.out.println("对象 ："+map.remove("girl6","路人乙")+" 已被删除");
        System.out.println("对象 ："+map.remove("girl7")+" 已被删除");
        //查询操作
        //map中有多少键值对
        System.out.println("当前的键值对大小为："+map.size());
        //map中girl3和girl6 的对应value
        System.out.println(map.get("girl3"));
        System.out.println(map.get("girl6"));
        //判断map是否为空
        System.out.println("map是否为空？  "+(map.isEmpty()?"是":"否"));
        //判断是否包含指定key
        System.out.println("map是否包含？  "+map.containsKey("girl1"));
        //判断是否包含指定value
        System.out.println("map是否包含指定value？  "+map.containsValue("路人甲"));
        //返回map的所有key组成的set集合
        System.out.println("返回的key的set集合 ："+map.keySet());
        //返回value组成的set集合
        System.out.println("value集合 ："+map.values());
        //返回键值对组成的set集合
        System.out.println("key=value "+map.entrySet());




    }
}
