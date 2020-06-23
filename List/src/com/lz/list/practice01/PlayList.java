package com.lz.list.practice01;

import java.util.Arrays;

/**
 * @ClassName PlayList
 * @Description: 球员集合
 * @Author: zzz
 **/
public class PlayList {
    //存储球员号码
    private Integer[] players = null;
    //存储场上球员数量
    private int size = 0;
    public PlayList(int initialCapacity){
        if (initialCapacity<0){
            throw new RuntimeException("初始容量不能为负");
        }
          this.players = new Integer[initialCapacity];
    }
    public PlayList(){
        this(5);
    }

    /**
     * 打印方法
     * @return
     */
    @Override
    public String toString(){
        if (players == null){
            //数组未初始化
            return "null";
        }
        if (size == 0){
            return "暂无球员";
        }
        StringBuilder sb =new StringBuilder(16);
        sb.append("[");
        for (int index = 0; index <size ; index++) {
            sb.append(players[index]);
            //不是最后一个数
            if (index!=size-1){
                sb.append(",");
            }else {
                //最后一个数后
                sb.append("]");
            }
        }
     return sb.toString();
    }

    /**
     * 增加球员方法
     * @param playerNumber 球员号码
     */
    public void add(Integer playerNumber){
        //判断容器是否装满
        if(size == players.length){
            //容器已满 需要扩容 2 倍
            this.players = Arrays.copyOf(players,size*2);
        }
        //保存球衣号码
        this.players[size] = playerNumber;
        //球员数量加1
        size++;
    }

    /**
     * 查询球员方法
     * @param index
     * @return
     */
    public Integer get(int index){
        if(index<0 || index >size){
            throw new RuntimeException("非法索引");
        }
        return players[index];
    }

    /**
     * 修改球员操作
     * @param index
     * @param newPlayerNumber
     */
    public void set(int index,Integer newPlayerNumber){
        if (index<0||index>size){
            throw new RuntimeException("非法索性");
        }
        players[index] = newPlayerNumber;
    }

    /**
     * 删除球员的方法
     * @param index
     */
    public void remove(int index){
        if (index<0||index>size){
            throw new RuntimeException("非法索引");
        }
        for (int i = index; i <size-1 ; i++) {
            players[i] = players[i+1];
        }
        players[size-1] = null;
        size--;
    }

}
