package com.lz.practice_01;

/**
 * 学生类
 * @author zzz
 *
 */
public class Student {
	private String no;//学生编号
	private String name;//学生名称
	private int score;//学生成绩
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	//计算学生平均成绩
	public static double getAvg(Student[] students) {
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			sum=sum+students[i].score;
		}
		return sum/students.length;
	}
	@Override
	public String toString() {
		return "学生信息  [学号=" + no + ", 姓名=" + name + ", 成绩=" + score + "]";
	}
	

}
