package com.lz.generalpractice_2.practice_1.practice_1;

/**
 * 工资高异常
 */
public class HighSalaryException extends RuntimeException {
    public HighSalaryException() {
    }
    public HighSalaryException(String message) {
        super(message);
    }
    public HighSalaryException(String message,Throwable cause) {
        super(message,cause);
    }

}
