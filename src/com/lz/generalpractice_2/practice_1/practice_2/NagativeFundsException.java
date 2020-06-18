package com.lz.generalpractice_2.practice_1.practice_2;

/**
 * 当取款数额为负数，抛出
 */
public class NagativeFundsException extends RuntimeException {
    public NagativeFundsException(String message) {
        super(message);
    }
}
