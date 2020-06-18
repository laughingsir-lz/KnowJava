package com.lz.practice_04;

/**
 * 正则表达式练习
 * 判断一个字符串是否全部有数字组成
 * 判断一个字符串是否是手机号码
 * 判断一个字符串是否是18位身份证号码
 * 判断一个字符串是否6到16位，且第一个字必须为字母
 */
public class RegexDemo {
    public static void main(String[] args) {
        //判断一个字符串是否全部由数字组成  数字最少出现一次
        System.out.println("132135496".matches("\\d"));//false
        System.out.println("132135496".matches("\\d+"));//true
        System.out.println("132as5496".matches("\\d+"));//false
        System.out.println("-----------分割线---------------");
        //判断一个字符串是否是手机号码
        //手机号11位 全数字 首位为1 次位为{3，4，5，7，8}，其余位无要求
        System.out.println("12345678894".matches("^1[34578]\\d{9}"));//false
        System.out.println("13345678894".matches("^1[34578]\\d{9}"));//true
        System.out.println("1534567889".matches("^1[34578]\\d{9}"));//false
        System.out.println("--------------------------");
        //判断一个字符串是否是18位身份证号码
        //十八位： ^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$
        String regex1 = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        System.out.println("125456456789456213".matches(regex1));
        System.out.println("53012119760427732X".matches(regex1));
        System.out.println("--------------------------");
        //判断一个字符串是否6到16位，且第一个字必须为字母
        String regex2 = "^[a-zA-Z]\\w{5,15}$";
        System.out.println("will".matches(regex2));
        System.out.println("1kajsdfklaw".matches(regex2));
        System.out.println("kaj123klaw".matches(regex2));

    }
}
