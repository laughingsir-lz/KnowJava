package com.lz.stringutil;

/**
 * @author zzz
 * 字符串判空
 */
public class StringUtil {
    /**
     *  字符串的判空   空引用和空字符串  null  ""
     */
    private StringUtil(){}
    public static boolean hasLength(String val){
        return val != null && !"".equals(val.trim());
    }
}
