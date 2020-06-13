package com.lz.practice_01;

public class User {
	private String id;
	private String userName;
	private String passWord;
	private String emailAddr;
    static int totalUser=0;
	public User(String id, String userName) {
		this.id = id;
		this.userName = userName;
		emailAddr = userName +"@gameschool.com";
		totalUser++;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", emailAddr=" + emailAddr
				+ "]";
	}

}
