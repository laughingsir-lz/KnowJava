package com.lz.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName DriverDemo
 * @Description:
 * @Author: zzz
 **/
public class DriverDemo {
    public Connection getDriver() throws ClassNotFoundException, SQLException {
        //加载注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //连接所需的信息
        String url ="jdbc:mysql://localhost:3306/lz?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String password = "123456";
        //获取连接对象
        Connection conn = DriverManager.getConnection(url, userName,password);
        return  conn;
    }
}
