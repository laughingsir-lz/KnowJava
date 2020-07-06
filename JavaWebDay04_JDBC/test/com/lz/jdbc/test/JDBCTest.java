package com.lz.jdbc.test;

import org.junit.Test;

import java.sql.*;

/**
 * @ClassName JDBCTest
 * @Description:
 * @Author: zzz
 **/
public class JDBCTest {
    @Test
    public void testGetConnection() throws ClassNotFoundException, SQLException {
        //1 加载注册驱动  驱动被注册到DriverManager中
        Class.forName("com.mysql.jdbc.Driver");
        //2 获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lz", "root", "123456");
        System.out.println(connection);
    }

    @Test
    public void testInsert() throws ClassNotFoundException, SQLException {
        //加载注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接对象
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/lz?useUnicode=true&characterEncoding=utf8",
                "root", "123456");
        //获取语句对象
        Statement statement = connection.createStatement();
        String sql = "insert into student(name,email,age) " +
                "values ('小胖333','xiaopang@email',18)";
        //执行语句
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        //释放流资源
        //statement.close();
        connection.close();
        //结果

    }
}
