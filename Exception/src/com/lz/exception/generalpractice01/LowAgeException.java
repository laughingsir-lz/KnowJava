package com.lz.exception.generalpractice01;

/**
 * 自定义异常年龄低异常
 * @author zzz
 */
public class LowAgeException extends RuntimeException {
    public LowAgeException() {
        super();
    }
    public LowAgeException(String message) {
        super(message);
    }
    public LowAgeException(String message,Throwable cause) {
        super(message,cause);
    }
}
