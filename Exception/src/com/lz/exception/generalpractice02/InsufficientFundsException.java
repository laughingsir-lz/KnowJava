package com.lz.exception.generalpractice02;

/**
 * 当取款的数额大于存款时，抛出
 * @author zzz
 */
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(){super();}
    public InsufficientFundsException(String message) {
        super(message);
    }
}
