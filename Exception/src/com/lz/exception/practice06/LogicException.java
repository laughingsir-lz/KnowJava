package com.lz.exception.practice06;

/**
 * 自定义异常 LogicException
 * 继承 RuntimeException
 * @author zzz
 */
public class LogicException extends RuntimeException {
    public LogicException() {
        super();
    }
    public LogicException(String message) {
        //调用父类构造器
        super(message);
    }
}
