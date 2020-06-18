package com.lz.generalpractice_1.practice_4;

/**
 * 提取字符串数组中的数字 求和 求平均值
 */
public class StringDemo {
    public static void main(String[] args) {
        String[] strs = {"2+3+4","2+4","5+6","9+7"};
        int sum = 0;
        int count = 0;
        for (int i = 0; i <strs.length ; i++) {
            String[] s = strs[i].split("\\D");
            for (int j = 0; j <s.length ; j++) {
                sum += Integer.parseInt(s[j]);
                count++;
            }
        }
        System.out.println("总和 "+sum);
        System.out.println("平均值 "+((double)sum/(double)count));
    }
}
