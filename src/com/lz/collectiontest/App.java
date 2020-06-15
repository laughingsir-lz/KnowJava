package com.lz.collectiontest;

/**
 * 球员列表测试类
 */
public class App {
    public static void main(String[] args) {
        PlayerList playerList1 = new PlayerList(10);
        System.out.println(playerList1);
        //添加球员
        playerList1.add(11);
        playerList1.add(22);
        playerList1.add(33);
        playerList1.add(44);
        playerList1.add(55);
        playerList1.add(66);
        System.out.println(playerList1);
        System.out.println(playerList1.get(3));


    }
}
