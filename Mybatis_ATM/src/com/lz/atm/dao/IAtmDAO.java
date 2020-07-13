package com.lz.atm.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName IAtmDAO
 * @Description:
 * @Author: zzz
 **/
public interface IAtmDAO {
    /**
     * 存款
     * @param money 存入的金额
     * @param cardNum 卡号
     * @return 返回存款信息
     */
    void add (BigDecimal money, String cardNum);

    /**
     * 取款
     * @param money 取出的金额
     * @param cardNum 卡号
     * @return 返回取款信息
     */
    void draw(BigDecimal money,String cardNum) throws SQLException;

    /**
     * 转账
     * @param money 转账金额
     * @param cardNum 转出账户
     * @param to 转入账户
     * @return 返回转账信息
     */
    String transfer(BigDecimal money,String cardNum,String to);
    /**
     * 查询余额
     * @param cardNum 查询的账户
     * @return 返回余额
     */
    BigDecimal inquire(String cardNum);

    /**
     * 打印流水账单
     * @param cardNum 流水单用户
     * @return 流水信息集合
     */
    List<String> silpPrint(String cardNum);

    /**
     * 开户
     * @param name 开户名
     * @param pwd 密码
     */
    void register(String name,String pwd);

    /**
     * 登录
     * @param cardNum 卡号
     * @param pwd 密码
     * @return 判断登录成功与否
     */
    boolean login(String cardNum,String pwd);
}
