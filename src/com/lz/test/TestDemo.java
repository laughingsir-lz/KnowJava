package com.lz.test;

import sun.util.resources.hr.CalendarData_hr;

import java.util.List;

public class TestDemo {
    public static void main(String[] args){

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("123").append(456);
        StringBuffer ss = new StringBuffer();
        ss.append("123").append(123);
        System.out.println(ss);
        TestDemo.printDigit(123456);
    }
    static void  printDigit(int num){
        if (num<0){
            System.out.println("参数非法！");
        }
        //拿到末位
        String string = "";
        do{
            int newnum = num % 10;
            num = num /10;
            if (num>0){
                string= string+ newnum +",";
            }else {
                string =string + newnum+"。";
            }
        }while (num>0);
        System.out.println(string);
        char c = 80;
        System.out.println(c);

    }

}
