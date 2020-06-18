package com.lz.practice_04;

import java.util.UUID;

/**
 * 使用随机数UUID类，通过UUID类获取随机数
 * 通过UUID类，获取验证码
 */
public class UUIDDemo {
    public static void main(String[] args) {
        //得到随机uuid对象
        UUID uuid =UUID.randomUUID();
        System.out.println(uuid);
        //得到UUID的前五个字母作为验证码
        String code = uuid.toString().substring(0,5);
        System.out.println(code.toUpperCase());
    }
}
