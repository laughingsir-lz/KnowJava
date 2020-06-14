package com.lz.practice_02;

/**
 * 杯子类  茶杯和咖啡杯的父类
 */
public class Cup {
    private String color;//颜色
    private  int capacity;//容量
    public Cup() {
    }
    public Cup(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
    }
    //父类中的room()方法
    public String room(){
       return "装液体";
    }
    @Override
    public String toString() {
        return "Cup{" +
                "颜色='" + color + '\'' +
                ", 容量=" + capacity + "    调用装方法 ："+room()+
                '}';
    }
}
