package com.lz.generalpractice_2.practice_1.practice_2;

/**
 * 当取款的数额大于存款时，抛出
 */
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
