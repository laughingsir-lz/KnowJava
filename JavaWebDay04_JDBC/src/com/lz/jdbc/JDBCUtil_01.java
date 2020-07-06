package com.lz.jdbc;

import java.sql.*;


/**
 * @ClassName JDBCUtil
 * @Description:
 * @Author: zzz
 **/
public class JDBCUtil_01 {
    static {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    /**
     * 释放资源
     */
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取连接
     * @return coon
     * @throws Exception
     */
     public  static Connection getConnection() throws Exception{
         //加载注册驱动
         //Class.forName("com.mysql.jdbc.Driver");
         //连接所需的信息
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/lz?useUnicode=true&characterEncoding=utf8",
                 "root","123456");
     }
}
