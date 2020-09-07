package com.lz.ssm.exception;

/**
 * 自定义的逻辑异常
 *
 * @author zzz
 */
public class LogicException extends RuntimeException {
    public LogicException(String errMsg) {
        super(errMsg);
    }

    ;
}
