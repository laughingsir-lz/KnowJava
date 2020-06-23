package com.lz.exception.generalpractice02;

/**
 * 当取款数额为负数，抛出
 * @author zzz
 */
public class NegativeFundsException extends RuntimeException {
    public NegativeFundsException(){super();}
    public NegativeFundsException(String message) {
        super(message);
    }
}
