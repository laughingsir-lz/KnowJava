package com.lz.web.test;

import com.lz.stringutil.StringUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName com.lz.web.test.TestDemo
 * @Description:
 * @Author: zzz
 **/
public class TestDemo {
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        InputStream in = new FileInputStream(new File("Resources\\db.properties"));
        p.load(in);
        System.out.println(p.getProperty("username"));
        System.out.println(p.getProperty("password"));
    }
}
