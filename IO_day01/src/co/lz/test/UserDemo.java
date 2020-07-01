package co.lz.test;

import java.util.*;

/**
 * @ClassName UserDemo
 * @Description:
 * @Author: zzz
 **/
public class UserDemo {
    public static void main(String[] args) {
        Set<User> userSet = new HashSet<>();
        userSet.add(new User(1,"xxx",18));
        userSet.add(new User(2,"zzz",19));
        userSet.add(new User(3,"aaa",30));
        userSet.add(new User(1,"xxx",18));
        System.out.println(userSet);
        Map<String,User>userMap = new HashMap<>();
        int count=0;
        for (User user : userSet) {
            userMap.put("user"+count,user);
            count++;
        }
        System.out.println(userMap);
        List<Map.Entry<String,User>> ulist = new ArrayList<>();
        Set<Map.Entry<String, User>> entries = userMap.entrySet();
        Iterator<Map.Entry<String, User>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, User> next = iterator.next();
            ulist.add(next);
        }
        System.out.println(ulist);
        Integer integer = 0;
        integer++;
    }
}
