package com.lz.practice_04;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 创建Calendar对象
 * 并分别设置和获取日期的年、月、日、时、分、秒。
 */
public class CalendarDemo {
    public static void main(String[] args) throws ParseException {
        //创建Calendar对象
        Calendar calendar  =Calendar.getInstance();
        //获取年
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        //获取月
        int month = calendar.get(Calendar.MONTH)+1;
        System.out.println(month);
        //获取日期
        int date = calendar.get(Calendar.DAY_OF_MONTH);//当月第几天 日期
        int date1 = calendar.get(Calendar.DAY_OF_WEEK);//当周第几天
        int date2 = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);// 星期几
        int date3 = calendar.get(Calendar.DAY_OF_YEAR);//在当年第几天
        System.out.println(date+" ,"+date1+" ,"+date2+" ,"+date3);
        //获取时
        int hour = calendar.get(Calendar.HOUR);//12小时制
        int hour1 = calendar.get(Calendar.HOUR_OF_DAY);//24小时制
        System.out.println(hour+" ,"+hour1);
        //获取分
        int minute = calendar.get(Calendar.MINUTE);
        //获取秒
        System.out.println(minute);
        int second = calendar.get(Calendar.SECOND);
        System.out.println(second);
        //利用 Calendar类设置年、月、日、时、分、秒
        String input = "2018-08-15 15:57:58";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat();
        //设置格式
        sdf.applyPattern(pattern);
        //解析字符串日期形式
        Date date4 = sdf.parse(input);
        //设置日期
        calendar.setTime(date4);
        System.out.println(calendar.getTime());
//        calendar.add(Calendar.YEAR,1);
//        calendar.add(Calendar.MONTH,1);
//        calendar.add(Calendar.DAY_OF_MONTH,1);
//        System.out.println(calendar.get(Calendar.YEAR) +"年"
//                +calendar.get(Calendar.MONTH)+"月"
//                +calendar.get(Calendar.DAY_OF_MONTH)+"日");

    }
}
