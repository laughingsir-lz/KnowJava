package com.lz.practice_02;

/**
 * 蚂蚁类  继承Insect类  实现 IFlyable接口
 */
public class Ant extends Insect implements IFlyable{
    private  String name;
    public Ant() {
        super();
        this.name = "蚂蚁";
    }
    @Override
    public void lay() {
        super.lay();
    }
    @Override
    public void fly() {
        System.out.println("除了飞蚁，蚂蚁都只能爬");
    }
    @Override
    public String toString() {
        return name+super.toString();
    }
}
