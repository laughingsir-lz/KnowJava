package com.lz.practice_01;

public class User {
	private String id;
	private String userName;
	private String passWord;
	private String emailAddr;
    static int totalUser=0;
    //javaBean规范 出现有参构造器 就必须有无参构造器
	public User (){}
	public User(String id, String password) {
		this.id = id;
		this.passWord = password;
		totalUser++;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailAddr() {
		return this.userName +"@gameschool.com";
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", emailAddr=" + getEmailAddr()
				+ "]";
	}
}
