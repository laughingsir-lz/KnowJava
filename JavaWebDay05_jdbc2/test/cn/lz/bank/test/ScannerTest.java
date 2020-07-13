package cn.lz.bank.test;

import java.util.Scanner;

/**
 * @ClassName ScanerTest
 * @Description:
 * @Author: zzz
 **/
public class ScanerTest {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();
            int sum = 0;

            while (nextLine != null && !nextLine.equals("")) {
                sum += Integer.parseInt(nextLine);
                System.out.println(sum);
                nextLine = scanner.nextLine();
            }

            System.out.println("end of input integer");
        }
    }
}
