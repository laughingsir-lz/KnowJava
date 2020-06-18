package com.lz.practice_05;

/**
 * finally 语句块应用
 */
public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        System.out.println("Begin");
        //除数为0
        divide(17,0);
        System.out.println("Ending");
    }
    public static void divide(int a,int b){
        try {
            System.out.println(a/b);

        }catch (NumberFormatException e){
            //数字格式化异常
            e.printStackTrace();
        }catch (ArithmeticException e){
            //捕获ArithmeticException 类型的异常
            System.out.println("除法运算数有错误 ");
        }catch (Exception e){
            //捕获其他未知错误
            e.printStackTrace();
        }finally {
            //最终执行的语句块
            //释放资源
            System.out.println("最终语句块");
           System.exit(0);
        }
        }
    }
