package com.lz.practice_01;

public class UserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user1 = new User("001", "1��ѡ��");
		User user2 = new User("002", "2��ѡ��");
		User user3 = new User("003", "3��ѡ��");
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		System.out.println("�û�������"+User.totalUser);
	}

}
