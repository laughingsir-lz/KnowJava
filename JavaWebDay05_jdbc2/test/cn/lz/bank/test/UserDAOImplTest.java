package cn.lz.bank.test;

import cn.lz.bank.dao.IUserDAO;
import cn.lz.bank.dao.impl.UserDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UserDAOImplTest {
    private IUserDAO userDAO = new UserDAOImpl();
    @Test
    public void add() {
        userDAO.add(new BigDecimal("55"),"6228485");
    }

    @Test
    public void draw() throws SQLException {
        userDAO.draw(new BigDecimal("700"),"6228485");
    }

    @Test
    public void transfer() {
    }

    @Test
    public void inquire() {
    }

    @Test
    public void silpPrint() {
    }
    @Test
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号：");
        String nextLine = scanner.nextLine();
        if (nextLine.equals("xxx")){
            System.out.println("账户错误");
        }
    }
}