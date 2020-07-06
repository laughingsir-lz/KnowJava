package com.lz.jdbc.test;

import com.lz.jdbc.DriverDemo;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class DriverDemoTest {
    private DriverDemo driverDemo = new DriverDemo();
    @Test
    public void testGetDriver() throws SQLException, ClassNotFoundException {
        System.out.println(driverDemo.getDriver());
    }
    @Test
    public void testInsert() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO student(name,email,age) VALUES ('测试2','测试2@email',130)" ;
        Connection conn = driverDemo.getDriver();
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
        st.close();
        conn.close();
    }
}