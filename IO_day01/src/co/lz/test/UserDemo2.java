package co.lz.test;

import java.util.*;

/**
 * @ClassName UserDemo2
 * @Description:  修改版
 * @Author: zzz
 **/
public class UserDemo2 {
    public static void main(String[] args) {
        //创建set集合 不重复对象
        Set<User> userSet = new HashSet<>();
        userSet.add(new User(1,"xxx",18));
        userSet.add(new User(2,"zzz",19));
        userSet.add(new User(3,"aaa",30));
        userSet.add(new User(1,"xxx",18));
        System.out.println(userSet);
        //创建存放map的集合list
        List<Map<String,Object>> ulist = new ArrayList<>();
        //创建Map
        //在map中value位置的数据类型不唯一的时候，直接object对象
        //一个Map一个javaBean对象
        Map<String,Object> userMap ;
        for (User user : userSet) {
            userMap = new HashMap<>();
            userMap.put("id",user.getId());
            userMap.put("name",user.getName());
            userMap.put("age",user.getAge());
            System.out.println(userMap);
            //完成list中的map对象添加
            ulist.add(userMap);
        }
        System.out.println(ulist);
        int[] a ={1,2,3};
        System.out.println(UserDemo2.getSum(a));
    }
    static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {//遍历长度
            sum+=arr[i];//总数
        }
        return sum;
    }

}
