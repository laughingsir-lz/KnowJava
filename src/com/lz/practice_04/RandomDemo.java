package com.lz.practice_04;

import java.util.Random;

/**
 * 使用随机数Random类，
 * 通过Random类获取伪随机数
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random =new Random();
        //无限制 生成一个int范围内的随机数
        System.out.println(random.nextInt());
        //生成一个100以内的随机数
        int intNum1 = random.nextInt(100);
        System.out.println(intNum1);
        //随机获取A`Z之间的5个字母组成的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int intNum2 = 65+random.nextInt(25);
            char ch = (char) intNum2;
            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder);
    }
}
