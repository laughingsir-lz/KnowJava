package com.lz.practice_02;

/**
 * Animal测试
 */
public class AnimalDemo {
    public static void main(String[] args) {
        //把子类对象赋给父类  多态
        //创建一个person 对象
        Animal person = new Person();
        person.setName("唐僧");
        System.out.println(person);
        //创建一个monkey对象
        Animal monkey = new Monkey();
        monkey.setName("悟空");
        System.out.println(monkey);
    }
}
