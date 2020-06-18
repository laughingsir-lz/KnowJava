package com.lz.generalpractice_2.practice_1.practice_2;

/**
 *银行账户测试类
 */
public class AccountDemo {
    public static void main(String[] args) {
        //初始化账户  余额100.00
        Account account = new Account(100.00);
        //account.withDrawal(150);//余额不足
        account.withDrawal(-15);
    }
}
