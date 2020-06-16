package com.lz.practice_03;

/**
 * 实现功能对指定的敏感词汇进行过滤替换
 * 把敏感词过滤成*号输出
 */
public class FiltrationDemo {
    public static void main(String[] args) {
        //过滤数组
        String[] filtrArr = {"卧槽","他妈的","sb"};
        //输入字符串
        String string = "他妈的,你揍他";
        //替换字符串
        String re="";
        //输出字符串
        String s="";
        //遍历过滤数组，对每一个字符串都做过滤判断
        for (int i = 0; i <filtrArr.length ; i++) {
            //得到过滤字符串
            if (string.contains(filtrArr[i])){
                //生成替代字符串
                for (int j = 0; j <filtrArr[i].length() ; j++) {
                    re += "*";
                }
                //完成字符串替代
                s =string.replace(filtrArr[i],re);
            }else {
                s = string;
            }
        }
        System.out.println(s);
    }
}
