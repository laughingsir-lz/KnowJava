package com.lz.practice_02;

/**
 * 大雁类   继承Bird类  实现IFlyable接口
 */
public class DaYan extends Bird implements IFlyable {
    private  String name;
    public DaYan() {
        super();
        this.name = "大雁";
    }
    @Override
    public void lay() {
        super.lay();
    }
    @Override
    public void fly() {
        System.out.println("大雁南飞");
    }

    @Override
    public String toString() {
        return name+super.toString();
    }
}
