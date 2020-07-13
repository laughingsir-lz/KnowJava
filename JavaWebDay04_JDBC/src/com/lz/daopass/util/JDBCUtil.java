package com.lz.daopass.util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.StatementImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName JDBCUtil
 * @Description:
 * @Author: zzz
 **/
public class JDBCUtil {
    /**
     * 释放资源
     * @param conn 连接对象
     * @param pst 语句对象
     * @param rs 结果集对象
     */
    public static  void close(Connection conn, Statement pst, ResultSet rs){
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
}
