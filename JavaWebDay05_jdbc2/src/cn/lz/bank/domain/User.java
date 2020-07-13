package cn.lz.bank.domain;

import java.math.BigDecimal;

/**
 * @ClassName User
 * @Description:
 * @Author: zzz
 **/
public class User {
    private Long id;
    private String userName;
    private String cardNum;
    private BigDecimal balance;

    public User() {
    }

    public User(Long id, String userName, String cardNum, BigDecimal balance) {
        this.id = id;
        this.userName = userName;
        this.cardNum = cardNum;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", balance=" + balance +
                '}';
    }
}
