package cn.lz.bank.dao.impl;

import cn.lz.bank.dao.IUserDAO;
import cn.lz.bank.util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @ClassName UserDAOImpl
 * @Description:
 * @Author: zzz
 **/
public class UserDAOImpl implements IUserDAO {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    StringBuilder sb = new StringBuilder();

    @Override
    public void add(BigDecimal money, String cardNum) {
        try {
            //获取连接
            conn = JDBCUtil.getConn();
            //设置事务为手动提交
            conn.setAutoCommit(false);
            //预编译语句
            //存款语句
            String up = "update user set balance=balance+? where cardNum=?";
            pst = conn.prepareStatement(up);
            //设值
            pst.setBigDecimal(1, money);
            pst.setString(2, cardNum);
            //执行存款操作
            pst.executeUpdate();
            //模拟异常
            //int j= 1/0;
            //查看余额
            //余额语句
            String sql = "select username,balance from user where cardNum=?";
            pst = conn.prepareStatement(sql);
            //设值
            pst.setString(1, cardNum);
            //执行查看余额语句
            rs = pst.executeQuery();
            conn.commit();
            if (rs.next()) {
                BigDecimal balance = rs.getBigDecimal("balance");
                char[] chars = rs.getString("username").toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (i == 1 || i == chars.length - 2) {
                        chars[i] = '*';
                    }
                    sb.append(chars[i]);
                }
                System.out.println("用户名： " + sb);
                System.out.println("当前余额为： " + balance);
            }
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //throw new RuntimeException("系统故障 ！！！请取回钞票！！");
            System.out.println("系统故障 ！！！请取回钞票！！");
        } finally {
            JDBCUtil.close(conn, pst, rs);
        }
        return;
    }

    @Override
    public void draw(BigDecimal money, String cardNum)  {
        try {
            //获取连接
            conn = JDBCUtil.getConn();
            //设置事务
            conn.setAutoCommit(false);
            //预编译语句
            String sql = "select * from user where cardNum=? and balance>=?";
            pst = conn.prepareStatement(sql);
            //设值
            pst.setString(1, cardNum);
            pst.setBigDecimal(2, money);
            //执行语句
            rs = pst.executeQuery();
            //判断余额
            if (!rs.next()) {
                System.out.println("余额不足");
                return;
            }
            //余额充足 取款
            //预编译语句
            String sql1 = "update user set balance = balance-? where cardNum =?";
            //获取语句对象
            pst = conn.prepareStatement(sql);
            //设值
            pst.setBigDecimal(1, money);
            pst.setString(2, cardNum);
            //执行取款
            pst.executeUpdate();
           conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            JDBCUtil.close(conn,pst,rs);
        }
        return;
    }

    @Override
    public String transfer(BigDecimal money, String cardNum, String to) {
        return null;
    }

    @Override
    public BigDecimal inquire(String cardNum) {
        return null;
    }

    @Override
    public void silpPrint(String cardNum) {

    }
}
