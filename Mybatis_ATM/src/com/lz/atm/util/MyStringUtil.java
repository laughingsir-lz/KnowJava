package com.lz.atm.util;

import com.lz.atm.domain.User;

/**
 * @ClassName StringUtil
 * @Description:
 * @Author: zzz
 **/
public class StringUtil {
    public static void infoPrint(User user){
        StringBuilder sb = null;
        char[] chars = user.getUsername().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 1 || i == chars.length - 2) {
                chars[i] = '*';
            }
            sb.append(chars[i]);
        }
        System.out.println("用户名： " + sb);
        System.out.println("当前余额为： " + user.getBalance());
    }
}
