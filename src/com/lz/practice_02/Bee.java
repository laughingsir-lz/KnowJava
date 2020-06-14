package com.lz.practice_02;

/**
 * 蜜蜂类  继承Insect类  实现IFlyable接口
 */
public class Bee extends Insect implements IFlyable{
    private  String name;
    public Bee() {
        super();
        this.name = "蜜蜂";
    }
    @Override
    public void lay() {
        super.lay();
    }
    @Override
    public void fly() {
        System.out.println("飞在花丛中");
    }
    @Override
    public String toString() {
        return name+super.toString();
    }
}
