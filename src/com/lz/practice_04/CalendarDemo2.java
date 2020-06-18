package com.lz.practice_04;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 查询某个时间最近一周的信息
 * 如何表示最近这一周的开始时间和结束时间
 *
 */
public class CalendarDemo2 {
    public static void main(String[] args) throws ParseException {
        String input = "2018-08-15 15:57:58";  //输入日期
        String pattern = "yyyy-MM-dd HH:mm:ss"; //日期格式
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(pattern); //设置格式
        Date date = sdf.parse(input); //解析字符串日期形式
        Calendar calendar =Calendar.getInstance(); //创建calendar对象
        calendar.setTime(date); //将输入日期转换成calendar对象
        calendar.set(Calendar.HOUR_OF_DAY,23); //对时、分、秒修改成指定的 23:59:59
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        Date endDate = calendar.getTime();
        //得到最近一周  从当天往前返回7天
        calendar.add(Calendar.SECOND,1);   // 加一秒
        calendar.add(Calendar.DAY_OF_MONTH,-7); //往前退7天
        Date beginDate =calendar.getTime();  //得到最近一周开始的时间
        System.out.println("开始时间："+beginDate.toLocaleString()
                +"\n"+"结束时间："+endDate.toLocaleString());
    }
}
