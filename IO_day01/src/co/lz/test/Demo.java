package co.lz.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName Demo
 * @Description:
 * @Author: zzz
 **/
public class Demo {
    public static void main(String[] args) {
        List list = new ArrayList();
        Random random = new Random();
        int count=0;
        while (count<10){
            //int nextInt = random.nextInt(20);
            //double nextInt = Math.random()*20;
            BigDecimal nextInt = new BigDecimal(Math.random()*20);
            if (nextInt.compareTo(new BigDecimal(1))==1 &&!list.contains(nextInt)){
                list.add(nextInt.setScale(2, RoundingMode.HALF_UP));
                count++;
            }
        }
        System.out.println(list);
    }
}
