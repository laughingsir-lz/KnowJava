package com.lz.learnning.Demo;
import java.util.*;

/**
 * @ClassName JavaLineDemo
 * @Description:
 * @Author: zzz
 **/
public class JavaLineDemo {
    public  static void main(String[] args)  {
        int[] arr = {1,2,3,3,1,-1};
        System.out.println(Arrays.toString(get(arr)));
        String string = "asjdfkljw81235";
        string.toUpperCase();
        string.charAt(2);
        System.out.println(string.indexOf('w'));
        char[] chars = string.toCharArray();
        int count = 0;
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i]<123&&chars[i]>96){
                chars[i] = (char) (chars[i]-31);
                count++;
            }
        }
        System.out.println(count);

    }
    public static int[] get(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            if (!set.add(arr[i])){
                list.add(arr[i]);
            }
        }
        int[] arr2 = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            arr2[i] = list.get(i);
        }
        return arr2;
    }

}
