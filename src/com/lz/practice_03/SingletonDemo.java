package com.lz.practice_03;

/**
 * 单例模式测试类
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        Integer[] arr2 = {12,52,23,15,1,25,40};
        String[] str ={"it","is","a","wolf"};
        //普通方法引用  对象.方法
        //静态方法是可以用对象引用的，但是不推荐
        ArrayUtil2.getArrayUtil2().sort(arr2);
        //静态方法引用  类.方法
        ArrayUtil2.printS(str);
        //枚举实现 单例 调用
        ArrayUtil3.INSTANCE.sort(arr);
    }

}
