package com.lz.exception.practice04;

/**
 * 演示返回异常throw的使用
 * 抛出具体的异常对象
 * @author zzz
 */
public class ThrowDemo {
    public static void main(String[] args) {
        try {
            isExist("xxx");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static boolean isExist(String username) throws Exception {
        String[] data = {"will", "lucy", "xxx"};
        if (username != null && username.length() > 0) {
            for (String string : data) {
                if (string.equals(username)) {
                    //抛出具体的异常对象
                    throw new Exception("对不起，用户名：" + username + "已存在！");
                }
            }
        }
        return false;
    }
}
