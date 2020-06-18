package com.lz.generalpractice_1.expandpractice_1;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 拓展练习一
 */
public class EmployeeDemo {
    public static void main(String[] args) throws ParseException {
        String string = "name=小红&age=17&salary=8000.00&hireDate=1991-07-03;" +
                "name=小明&age=23&salary=10000.00&hireDate=1992-12-11;" +
                "name=小白&age=18&salary=12000.00&hireDate=1996-01-09;";
        //设置时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal sum = new BigDecimal("0.00"); //总金额
        int count = 0;//计数器
        String[] strings = string.split(";");//分割数组
        Employee[] employees = new Employee[strings.length];//员工信息数组
        for (int i = 0; i < strings.length; i++) {
            String[] s = strings[i].split("[&]");
            for (int j = 0; j < s.length; j++) {
                //组装员工信息
                Employee employee = new Employee();
                employee.setName(s[0].substring(5));
                employee.setAge(Integer.parseInt(s[1].substring(4)));
                employee.setSalary(s[2].substring(7));
                employee.setHireDate(s[3].substring(9));
                employees[i] = employee;
            }
            //判断入职日期
            Date bt = sdf.parse(s[3].substring(9));
            Date et = sdf.parse("1996-01-01");
            if (bt.before(et)) {
                //表示bt小于et
                BigDecimal bigDecimal = new BigDecimal(s[2].substring(7));
                sum = sum.add(bigDecimal);
                count++;
            }
            //员工信息
            System.out.println(employees[i]);
        }
        //输出平均值
        BigDecimal cBD = new BigDecimal(count);
        System.out.println("在1996年前入职的员工有：" + count + " 位；\n"
                + "平均工资为：" + sum.divide(cBD, 2, RoundingMode.HALF_UP));
    }
}
