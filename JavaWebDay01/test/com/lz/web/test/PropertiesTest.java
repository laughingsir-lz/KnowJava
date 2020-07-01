package com.lz.web.test;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.*;

public class PropertiesTest {

    @Test
    public void main() throws IOException {
        //使用类的加载器来获取字节码输出路径下的文件
        //1 获取类的加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        //2 使用类的加载器去获取字节码输出路径下的文件
        InputStream inputStream = contextClassLoader.getResourceAsStream("db.properties");
        //3 读取文件中内容
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));


    }
}