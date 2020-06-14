package com.lz.practice_02;

/**
 * 鸽子类  继承Bird类  实现Iflyable接口
 */
public class Pigeon extends Bird implements IFlyable{
    private  String name;
    public Pigeon() {
        super();
        this.name = "鸽子";
    }
    @Override
    public void lay() {
        super.lay();
    }
    @Override
    public void fly() {
        System.out.println("鸽子成群飞");
    }

    @Override
    public String toString() {
        return name+super.toString();
    }
}
