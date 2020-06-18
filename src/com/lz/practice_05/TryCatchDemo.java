package com.lz.practice_05;

/**
 * 单个异常 try-catch
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("Begin");
        //除数为0
        divide(17,0);
        System.out.println("Ending");
    }
    public static void divide(int a,int b){
        try {
            System.out.println(a/b);
        }catch (ArithmeticException e){//捕获ArithmeticException 类型的异常
            System.out.println("除法运算数有错误 ");
        }
    }
}
