package com.lz.collectiontest;

import java.util.Arrays;

public class PlayerList {
    private Integer[] players = null;
    private int size = 0;

    public PlayerList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new RuntimeException("初始化容量不能为负数");
        }
        this.players = new Integer[initialCapacity];
    }

    public PlayerList() {
        this(10);
    }

    //打印操作
    @Override
    public String toString() {
        if (players == null) {
            return "null";
        }
        if (size == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("[");
        for (int index = 0; index < size; index++) {
            stringBuilder.append(players[index]);
            if (index != size - 1) {
                stringBuilder.append(",");
            } else {
                stringBuilder.append("]");
            }
        }
        return stringBuilder.toString();
    }

    //保存操作
    public void add(Integer playerNumber) {
        //如果容器容量已满，此时扩容容器为原来容量的2倍
        if (size == players.length) {
            this.players = Arrays.copyOf(players, 2 * size);
        }
        //保存球员号码
        this.players[size] = playerNumber;
        //球员人数加一
        size++;
    }

    //查询操作
    public Integer get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引越界");
        }
        return players[index];
    }
    //修改操作

    public void set(int index, Integer newPlayerNumber) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引越界");
        }
        players[index] = newPlayerNumber;
    }

    //删除操作
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引越界");
        }
        //该球员后面的球员依次前移一位
        for (int i = index; i < size - 1; i++) {
            players[i] = players[i + 1];
        }
        //最后一个位置设为null
        players[size - 1] = null;
        //球员减一
        size--;
    }
}
