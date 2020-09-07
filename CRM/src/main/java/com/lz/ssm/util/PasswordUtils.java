package com.lz.ssm.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author zzz
 * @date 2020/8/27  11:39
 */
public abstract class PasswordUtils {
    public static String md5Pwd(String password, String name) {
        Md5Hash md5Hash = new Md5Hash(password, name, 2);
        return md5Hash.toHex();
    }
}
