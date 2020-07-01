package com.lz.listday02.generalpractice04;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName WorkerDemo
 * @Description:
 * @Author: zzz
 **/
public class WorkerDemo {
    public static void main(String[] args) {
        //指定添加位置
        int w = 0;
        //创建list
        List<Worker> list = new ArrayList<>();
        //创建工人对象
        Worker worker1 = new Worker("zhang3",18,3000);
        Worker worker2 = new Worker("li4",25,3500);
        Worker worker3 = new Worker("wang5",22,3200);
        //添加对象
        list.add(worker1);
        list.add(worker2);
        list.add(worker3);
        System.out.println(list);
        //在li4 之前插入一个工人
        for (int i = 0; i <list.size() ; i++) {
            //获取li4的索引位置
            if ("li4".equals(list.get(i).getName())){
                w = i;
            }
        }
        //添加一个新工人
        list.add(w,new Worker("zhao6",24,3300));
        System.out.println(list);
        // 删除wang5 的信息
        Iterator<Worker> iterator = list.iterator();
        while (iterator.hasNext()){
            Worker next = iterator.next();
            if ("wang5".equals(next.getName())){
                iterator.remove();
            }
        }
        System.out.println(list);
        //利用for 循环遍历，打印List 中所有工人的信息
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        //利用迭代遍历，对List中所有的工人调用work方法
        Iterator<Worker> iterator2 = list.iterator();
        while (iterator2.hasNext()){
            Worker next = iterator2.next();
            next.work();
        }
        //为Worker类重写equals 方法，当姓名、年龄、工资全部相等时候才返回true\
        System.out.println(worker1.equals(new Worker("zhang3", 18, 3000)));
        System.out.println(worker2.equals(new Worker("li4",25,3500)));
        System.out.println(worker3.equals(new Worker("wang5",22,3200)));
    }
}
