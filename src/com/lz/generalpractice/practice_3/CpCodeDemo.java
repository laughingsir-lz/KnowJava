package com.lz.generalpractice.practice_3;

public class CpCodeDemo {
    public static String getCpCode(double orderFee,String province){
        if (orderFee>128 || province.contains("广东省")){
            return "SF";
        }
        if(orderFee>58&&province.contains("北京市")){
            return "EMS";
        }else {
            return "ZTO";
        }
    }
    public static void main(String[] args) {
        System.out.println(CpCodeDemo.getCpCode(40, "北京市"));
        System.out.println(CpCodeDemo.getCpCode(60, "北京市"));
        System.out.println(CpCodeDemo.getCpCode(129, "北京市"));
        System.out.println(CpCodeDemo.getCpCode(40, "广东省"));
        System.out.println(CpCodeDemo.getCpCode(60, "四川"));
        String regex1 = "^[北京市]\\S*$";
        System.out.println("北京市二".matches(regex1));
    }
}
