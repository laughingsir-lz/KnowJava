package com.lz.exception.generalpractice01;

/**
 * 年龄高异常
 * @author zzz
 */
public class HighAgeException extends RuntimeException{
    public HighAgeException() {
        super();
    }
    public HighAgeException(String message) {
        super(message);
    }
    public HighAgeException(String message,Throwable cause) {
        super(message,cause);
    }
}
