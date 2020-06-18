package com.lz.generalpractice_2.practice_1.practice_2;

/**
 * 银行账户类
 */
public class Account {
    private double balance;
    public Account() {
    }
    public Account(double balance) {
        this.balance = balance;
    }
    public void withDrawal(double dAmount) {
        if (dAmount > this.balance) {
            throw new InsufficientFundsException("余额不足");
        }
        if (dAmount < 0) {
            throw new NagativeFundsException("非法数额");
        }
    }
}
