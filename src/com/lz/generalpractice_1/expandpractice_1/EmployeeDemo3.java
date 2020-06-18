package com.lz.generalpractice_1.expandpractice_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 拓展练习一  优化  降低循环，减少数组
 */
public class EmployeeDemo3 {
    public static void main(String[] args) throws ParseException {
        String string = "name=小红&age=17&salary=8000.00&hireDate=1991-07-03;" +
                "name=小明&age=23&salary=10000.00&hireDate=1992-12-11;" +
                "name=小白&age=18&salary=12000.00&hireDate=1996-01-09;";
        //字符串预处理
        String regex = "[a-zA-Z]*[=]";
        String string1 = string.replaceAll(regex, "").replace(";","&");
        //字符串切割
        String[] ss = string1.split("&");
        Employee[] employees = new Employee[3];//员工信息数组
        int j = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal sum = new BigDecimal("0.00"); //总金额
        int count = 0;//计数器
        for (int i = 0; i <ss.length ; i+=4) {
            //组装员工信息
            Employee employee = new Employee();
            employee.setName(ss[i]);
            employee.setAge(Integer.parseInt(ss[i+1]));
            employee.setSalary(ss[i+2]);
            employee.setHireDate(ss[i+3]);
            employees[j] = employee;
            System.out.println(employees[j]);
            j++;
            //判断入职日期
            Date bt = sdf.parse(ss[i+3]);
            Date et = sdf.parse("1996-01-01");
            if (bt.before(et)) {
                //表示bt小于et
                BigDecimal bigDecimal = new BigDecimal(ss[i+2]);
                sum = sum.add(bigDecimal);
                count++;
            }
        }
        //输出平均值
        BigDecimal cBD = new BigDecimal(count);
        System.out.println("在1996年前入职的员工有：" + count + " 位；\n"
                + "平均工资为：" + sum.divide(cBD, 2, RoundingMode.HALF_UP));
    }
}
