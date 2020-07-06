package com.lz.crud.test;

import com.lz.crud.dao.IEmployeeDao;
import com.lz.crud.dao.impl.EmployeeDaoImpl;
import com.lz.crud.domain.Employee;
import org.junit.Test;
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeDaoTest {
    private final IEmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void insert() {
        Employee employee = new Employee(null, "花花", 20, "女", new BigDecimal("4000"));
        System.out.println(dao.insert(employee));
    }

    @Test
    public void delete() {
        System.out.println(dao.delete(6L));
    }

    @Test
    public void update() {
        Employee employee = new Employee(5L, "花花", 20, "女", new BigDecimal("5000"));
        System.out.println(dao.update(employee));
    }

    @Test
    public void selectOne() {
        System.out.println(dao.selectOne(5L));
    }

    @Test
    public void selectList() {
        dao.selectList().forEach(System.out::println);
    }

    @Test
    public void testDate() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lz?characterEncoding=utf-8",
                    "root", "123456");
            String sql = "select * from emp";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-07-05");
                Date rsDate = rs.getDate("HIREDATE");
                System.out.println(rsDate);
            }
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            //释放流资源
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}