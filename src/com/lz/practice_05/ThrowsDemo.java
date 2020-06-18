package com.lz.practice_05;

/**
 * 演示返回异常throws的使用
 * 自身不处理，提醒调用者处理异常
 */
public class ThrowsDemo {
    public static void main(String[] args)  {
        try {
            divide(3, 1);
            divide(1, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    //除法可能会出现异常 但是自身不处理 用throws提交到调用者
    public static void divide(int a,int b) throws Exception {
        System.out.println(a/b);
    }
}
