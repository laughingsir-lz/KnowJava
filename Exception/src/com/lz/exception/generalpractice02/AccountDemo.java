package com.lz.exception.generalpractice02;

/**
 *银行账户测试类
 * @author zzz
 */
public class AccountDemo {
    public static void main(String[] args) {
        //初始化账户  余额100.00
        Account account = new Account(100.00);
        //account.withDrawl(150);//余额不足
        account.withDrawl(-15);
    }
}
