package com.lz.listday02.generalpractice05;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MapDemo
 * @Description:
 * @Author: zzz
 **/
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("stef", "pap");
        map.put("will", "javaWeb");
        map.put("neld ", "springmvc");
        map.put("hesj", "wms");
        map.put("bunny", "javaWeb");
        map.put("hhaiy", "javaSe");
        System.out.println(map);
        //添加一个新老师 dafei 教jdbc
        map.put("dafei", "jdbc");
        //hhaiy 改为教javaWeb
        //map修改就用put方法覆盖
        map.put("hhaiy", "javaWeb");
        System.out.println(map);
        //输出所有老师，以及老师教授课程
        System.out.println(map.entrySet());
        //查出所有教javaWeb的老师
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if ("javaWeb".equals(entry.getValue())) {
                System.out.println(entry.getKey() + "--->" + entry.getValue());
            }
        }
    }
}
