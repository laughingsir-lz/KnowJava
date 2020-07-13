package cn.lz.bank.test;

import cn.lz.bank.dao.IUserDAO;
import cn.lz.bank.dao.impl.UserDAOImpl;
import cn.lz.bank.ui.MenuUI;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @ClassName ATMTest
 * @Description:
 * @Author: zzz
 **/
public class ATMTest {
    @Test
    public void testATM() throws SQLException, InterruptedException {
        MenuUI m = new MenuUI();
        Scanner sc = new Scanner(System.in);
        IUserDAO userDAO = new UserDAOImpl();
        String money = null;
        while (true) {
            m.mainMenu();
            System.out.println("请输入您选择的操作编号：");
            String num1 = sc.next();
            if (num1.equals("1")) {
                m.regMenu();
                System.out.println("放弃请按‘*’键");
                System.out.println("请输入开户名：");
                sc.nextLine();
                String name = sc.nextLine();
                if ("*".equals(name.trim())) {
                    break;
                }
                System.out.println("请输入密码：");
                String pwd = sc.nextLine();
                userDAO.regist(name, pwd);
            } else if (num1.equals("2")) {
                m.loginMenu();
                System.out.println("请输入账号：");
                sc.nextLine();
                String cardNum = sc.nextLine();
                System.out.println("请输入密码：");
                String pwd = sc.nextLine();
                if (userDAO.login(cardNum, pwd)) {
                    while (true) {
                        m.subMenu();
                        System.out.println("请输入您选择的操作编号：");
                        String num2 = sc.next();
                        if (num2.equals("1")) {
                            m.thMenu();
                            System.out.println("当前余额为 ：" + userDAO.inquire(cardNum));
                            System.out.println("                           回车返回...");
                            sc.nextLine();
                            sc.nextLine();
                        } else if (num2.equals("2")) {
                            m.thMenu();
                            while (true) {
                                System.out.println("请输入取款金额：");
                                money = sc.nextLine();
                                if (money == null || "".equals(money.trim())) {
                                    System.out.println("金额有误 ，请重新输入：");
                                    money = sc.nextLine();
                                }
                                break;
                            }
                            userDAO.draw(new BigDecimal(money), cardNum);
                        } else if (num2.equals("3")) {
                            m.thMenu();
                            while (true) {
                                System.out.println("请放入存款：");
                                money = sc.nextLine();
                                if (money == null || "".equals(money.trim())) {
                                    System.out.println("请重新放入存款：");
                                    money = sc.nextLine();
                                }
                                break;
                            }
                            userDAO.add(new BigDecimal(money), cardNum);
                        } else if (num2.equals("4")) {
                            String tocordNum = null;
                            m.thMenu();
                            while (true) {
                                System.out.println("请输入需要转入资金的账户");
                                sc.nextLine();
                                tocordNum = sc.nextLine();
                                System.out.println("请输入转账金额：");
                                money = sc.nextLine();
                                if (money == null || "".equals(money.trim())) {
                                    System.out.println("金额有误 ，请重新输入：");
                                    money = sc.nextLine();
                                }
                                break;
                            }
                            System.out.println("转入账户为：" + tocordNum);
                            System.out.println("转出金额为：" + money);
                            System.out.println("回车确认                  *放弃转账");
                            String ss = sc.nextLine();
                            if ("*".equals(ss.trim())) {
                                break;
                            }
                            System.out.println(userDAO.transfer(new BigDecimal(money), cardNum, tocordNum));
                            for (int i =5; i >0 ; i--) {
                                Thread.sleep(1000);
                                System.out.println("剩余"+i+"秒离开本页...");
                            }
                        } else if (num2.equals("5")) {
                            m.thMenu();
                            if (userDAO.silpPrint(cardNum).size()==0){
                                System.out.println("暂无流水...");
                                System.out.println("                           回车返回...");
                            }else {
                                userDAO.silpPrint(cardNum).forEach(System.out::println);
                                System.out.println("请收好流水单...");
                                System.out.println("                           回车返回...");
                                sc.nextLine();
                                sc.nextLine();
                            }


                        } else if (num2.equals("6")) {
                            break;
                        } else {
                            System.out.println("操作无效！！！");
                        }
                    }
                    m.exitMenu();
                    break;
                }
            } else if (num1.equals("3")) {
                m.exitMenu();
                break;
            } else {
                System.out.println("操作无效！！！");
            }
        }
    }
}
