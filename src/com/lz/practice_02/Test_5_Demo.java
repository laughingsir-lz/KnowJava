package com.lz.practice_02;

/**
 * 类和接口关系测试
 */
public class Test_5_Demo {
    public static void main(String[] args) {
        //创建鸟类对象  未实现IFlyable接口  无fly()方法
        Bird bird1 = new Pigeon();
        System.out.println(bird1);
        bird1.lay();
        System.out.println("-----------------------------");
        //创建鸽子对象
        Pigeon pigeon = new Pigeon();
        System.out.println(pigeon);
        pigeon.lay();
        pigeon.fly();
        System.out.println("-----------------------------");
        //创建大雁对象
        DaYan daYan = new DaYan();
        System.out.println(daYan);
        daYan.fly();
        daYan.lay();
        System.out.println("-----------------------------");
        //创建蚂蚁对象
        Ant ant = new Ant();
        System.out.println(ant);
        ant.fly();
        ant.lay();
        System.out.println("-----------------------------");
        //创建蜜蜂对象
        Bee bee = new Bee();
        System.out.println(bee);
        bee.fly();
        bee.lay();
        System.out.println("-----------------------------");
        //创建昆虫对象  未实现IFlyable接口  无fly()方法
        Insect insect = new Insect();
        System.out.println(insect);
        insect.lay();
    }
}
