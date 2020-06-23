package com.lz.list.practice02;


import javax.xml.ws.BindingType;
import javax.xml.ws.soap.Addressing;
import java.util.Arrays;

/**
 * @ClassName MyArrayList
 * @Description: 存储任意数据类型的Arraylist实现
 * @Author: zzz
 **/
public class MyArrayList {
    //存储任意数据类型
    private Object[] objects = null;
    //存储大小
    private int size = 0;

    //初始化容量大小
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new RuntimeException("初始容量不能为负数");
        }
        this.objects = new Object[initialCapacity];
    }

    public MyArrayList() {
        //初始大小10
        this(10);
    }
    //至此，完成了一个MyArrayList 的初始化

    /**
     * 添加元素
     * @param newObj
     */
    public void add(Object newObj) {
        //判断空间能不能添加元素
        if (size == objects.length) {
            //空间满，则扩容2倍
            this.objects = Arrays.copyOf(objects, 2);
        }
        //元素添加
        this.objects[size] = newObj;
        size++;
    }

    /**
     * 查询指定索引位置的元素
     * @param index 索引位
     * @return 指定元素
     */
    public Object get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("非法索引");
        }
        return objects[index];
    }

    /**
     * 修改指定索引的元素
     * @param index
     * @param newObj
     */
    public void set(int index, Object newObj) {
        if (index<0||index>size){
            throw new RuntimeException("非法索性");
        }
        objects[index] = newObj;
    }

    /**
     * 删除指定索引的元素
     * @param index
     */
    public void remove(int index) {
        if (index<0||index>size){
            throw new RuntimeException("非法索性");
        }

        //循环前移指定索引位后面的元素
        for (int i = index; i <size-1 ; i++) {
            objects[i] =objects[i+1];
        }
        //单独处理最后一位
        objects[size] = null;
        //存储元素减一
        size--;
    }

    @Override
    public String toString() {
        //首先判断有没有初始化容器
        if (objects == null){
           return "null";
        }
        //初始化后，判断有没有元素
        if (size == 0){
         return "暂无数据！" ;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int index = 0; index <size ; index++) {
            sb.append(objects[index]);
            if (index==size-1){
                sb.append("]");
            }else {
                sb.append(",");
            }
        }
        return  sb.toString();
    }
}
