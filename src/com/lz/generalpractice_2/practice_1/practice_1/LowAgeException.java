package com.lz.generalpractice_2.practice_1.practice_1;

/**
 * 自定义异常年龄低异常
 */
public class LowAgeException extends RuntimeException {
    public LowAgeException() {
    }
    public LowAgeException(String message) {
        super(message);
    }
    public LowAgeException(String message,Throwable cause) {
        super(message,cause);
    }
}
