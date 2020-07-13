package cn.lz.bank.dao;

import java.math.BigDecimal;

/**
 * @author zzz
 */
public interface IUserDAO{
     /**
      * 存款
      * @param money 存入的金额
      * @return 返回存款信息
      */
     String add (BigDecimal money);

     /**
      * 取款
      * @param money 取出的金额
      * @return 返回取款信息
      */
     String draw(BigDecimal money);

     /**
      * 转账
      * @param money 转账金额
      * @param username 转出账户
      * @param to 转入账户
      * @return 返回转账信息
      */
     String transfer(BigDecimal money,String username,String to);
     /**
      * 查询余额
      * @param username 查询的账户
      * @return 返回余额
      */
     BigDecimal inquire(String username);

     /**
      * 打印流水账单
      * @param username 流水单用户
      */
     void silpPrint(String username);
}
