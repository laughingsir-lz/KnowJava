package com.lz.practice_04;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用日期Date类常用方法
 * java.util.Date
 * 通过SimpleDateFormat类进行格式化和解析操作
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        //java.util.Date
        Date date = new java.util.Date();
        //默认欧美风格  当前年月日时间
        System.out.println(date);
        //本地风格   当前年月日时间
        System.out.println(date.toLocaleString());
        //System.out.println(date.toInstant());
        //获取当前系统时间距离1970年1月1日00：00：00以来的毫秒数
        long time = date.getTime();
        System.out.println(time);
        //获取当前日期
        System.out.println(date.getDate());
        //获取当前月份
        System.out.println(date.getMonth());
        //获取当前年份
        System.out.println(date.getYear() + 1900);
        //Date中的相关方法被淘汰 被Calendar类的相关方法替代
        //创建格式化对象sdf
        SimpleDateFormat sdf = new SimpleDateFormat();
        //设置格式
        String patten = "yyyy-MM-dd HH:mm:ss";
        sdf.applyPattern(patten);
        //格式化 format
        // Date类型转换为String类型： String format(date)
        String string =sdf.format(date);
        System.out.println(string);
        //解析 parse
        //String类型转换为Date类型：Date parse（string）
        String string1 = "2020/6/17 15:16:20";
        sdf.applyPattern("yyyy/M/dd HH:mm:ss");
        Date date1 = sdf.parse(string1);
        System.out.println(date1);
        //无论是解析还是格式化都应该指定日期格式
    }
}
