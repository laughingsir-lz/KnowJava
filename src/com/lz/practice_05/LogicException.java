package com.lz.practice_05;



/**
 * 自定义异常 LogicException
 * 继承 RuntimeException
 */
public class LogicException extends RuntimeException{
    public LogicException(String meseage){
        super(meseage);
    }
}
