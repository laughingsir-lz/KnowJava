package com.lz.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @ClassName JdbcUtil2
 * @Description:
 * @Author: zzz
 **/
public class JdbcUtil2 {
    private JdbcUtil2() {
    }

    private static Properties properties;

    static {
        //加载注册驱动
        //该操作在整个程序中只需要加载一次
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            properties = new Properties();
            properties.load(inputStream);
            Class.forName(properties.getProperty("driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }
}
