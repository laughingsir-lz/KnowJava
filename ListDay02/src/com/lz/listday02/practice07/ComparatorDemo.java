package com.lz.listday02.practice07;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName ComparatorDemo
 * @Description:使用Comparator接口根据用户的名字长度排序，如果名字相同按照年龄排序。
 * @Author: zzz
 **/
public class ComparatorDemo {

    static class NameLengthComparator implements Comparator<User>{
        @Override
        public int compare(User o1, User o2) {
            int ret = o1.getName().length() -o2.getName().length();
            if(ret>0){
                return 1;
            }else if (ret<0){
                return -1;
            }else {
                if (o1.getAge()>o2.getAge()){
                    return 1;
                }else if (o1.getAge()<o2.getAge()){
                    return -1;
                }
                return 0;
            }

        }
    }

    public static void main(String[] args) {
        TreeSet<User> users = new TreeSet<>(new NameLengthComparator());
        users.add(new User("James",30));
        users.add(new User("Bryant",25));
        users.add(new User("Allen",22));
        users.add(new User("Will",18));
        System.out.println(users);
    }
}
