package com.lz.practice_02;

/**
 * 机动车测试
 */
public class MotorVehicDemo {
    public static void main(String[] args) {
        //创建第一个机动车对象
        MotorVehicle motorVehicle1 = new MotorVehicle();
        motorVehicle1.setNumber_plate("辽A9752");
        motorVehicle1.addSpeed();
        System.out.println(motorVehicle1);
        //创建第二个机动车对象
        MotorVehicle motorVehicle2 = new MotorVehicle("辽B5086",150,200);
        motorVehicle2.lessSpeed();
        System.out.println(motorVehicle2);
    }
}
