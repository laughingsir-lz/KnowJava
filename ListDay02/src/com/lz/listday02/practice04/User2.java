package com.lz.listday02.practice04;

import javax.naming.Name;
import java.security.PrivateKey;
import java.util.Objects;

/**
 * @ClassName User2
 * @Description: HashSetDemo2 测试用的对象类
 * @Author: zzz
 **/
public class User2 {
    private String name;
    private int age;

    public User2() {
    }

    public User2(String name, int age) {
       this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User2 user2 = (User2) o;
        if(age!=user2.age){
            return false;
        }
        if (name==null&&user2.name!=null){
            return false;
        }else if (!name.equals(user2.name)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
       // return Objects.hash(name, age);
        final int prime = 31;
        int result = 1;
        result = prime * result +age;
        result = prime * result +((name==null)?0:name.hashCode());
        return  result;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
