package com.lz.list.practice01;

/**
 * @ClassName Demo
 * @Description: PalyList测试类
 * @Author: zzz
 **/
public class Demo {
    public static void main(String[] args) {
        PlayList playList = new PlayList();
        playList.add(11);
        playList.add(22);
        playList.add(33);
        playList.add(44);
        playList.add(55);
        System.out.println(playList);
        System.out.println(playList.get(2));
        playList.set(2,333);
        System.out.println(playList.get(2));
        playList.remove(2);
        System.out.println(playList);
    }
}
