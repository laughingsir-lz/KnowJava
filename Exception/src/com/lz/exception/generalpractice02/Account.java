package com.lz.exception.generalpractice02;

/**
 * 银行账户类
 * @author zzz
 */
public class Account {
    private double balance;
    public Account() {
    }

    /**
     * 构造器 实例化对象时设置余额
     * @param balance
     */
    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * 取款操作方法
     * @param dAmount
     */
    public void withDrawl(double dAmount) {
        if (dAmount > this.balance) {
            //抛出 InsufficientFundsException异常
            throw new InsufficientFundsException("余额不足");
        }
        if (dAmount < 0) {
            //抛出 NegativeFundsException 异常
            throw new NegativeFundsException("非法数额");
        }
    }
}
