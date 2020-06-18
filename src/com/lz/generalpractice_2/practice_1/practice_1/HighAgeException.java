package com.lz.generalpractice_2.practice_1.practice_1;

/**
 * 年龄高异常
 */
public class HighAgeException extends RuntimeException{
    public HighAgeException() {
    }
    public HighAgeException(String message) {
        super(message);
    }
    public HighAgeException(String message,Throwable cause) {
        super(message,cause);
    }
}
