package co.lz.test;

/**
 * @ClassName TestDemo
 * @Description:
 * @Author: zzz
 **/
public class TestDemo {
    public static void main(String[] args) {
        String s1 ="叩丁狼";
        String s2 =new String("叩丁狼");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(String.valueOf(100)+"shi "+String.valueOf(100).length()+"wei shu");
    }
}
