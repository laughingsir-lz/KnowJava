package com.lz.web.user;

/**
 * @ClassName UserDaoImpl
 * @Description:
 * @Author: zzz
 **/
public class UserDaoImpl {
    public int add(int a, int b){
        return a+b;
    }
    public void delete(int index){
        System.out.println("删除了指定索引"+index+"的元素");
    }
}
