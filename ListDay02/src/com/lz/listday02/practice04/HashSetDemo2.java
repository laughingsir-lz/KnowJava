package com.lz.listday02.practice04;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName HashSetDemo2
 * @Description:
 * @Author: zzz
 **/
public class HashSetDemo2 {
    public static void main(String[] args) {
        Set<User2> user2s = new HashSet<>();
        user2s.add(new User2("xxx",18));
        //重复数据被去掉
        user2s.add(new User2("xxx",18));
        user2s.add(new User2("zzz",18));
        user2s.add(new User2("xxx",20));
        user2s.add(new User2("zzz",19));
        System.out.println(user2s);

    }
}
