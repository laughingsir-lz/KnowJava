package com.lz.exception.generalpractice01;

/**
 * 工资高异常
 * @author zzz
 */
public class HighSalaryException extends RuntimeException {
    public HighSalaryException() {
        super();
    }
    public HighSalaryException(String message) {
        super(message);
    }
    public HighSalaryException(String message,Throwable cause) {
        super(message,cause);
    }

}
