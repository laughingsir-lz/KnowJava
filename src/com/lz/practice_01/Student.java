package com.lz.practice_01;

/**
 * ѧ����
 * @author zzz
 *
 */
public class Student {
	private String no;//ѧ�����
	private String name;//ѧ������
	private int score;//ѧ���ɼ�
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
	//����ѧ��ƽ���ɼ�
	public static double getAvg(Student[] students) {
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			sum=sum+students[i].score;
		}
		return sum/students.length;
	}
	@Override
	public String toString() {
		return "ѧ����Ϣ  [ѧ��=" + no + ", ����=" + name + ", �ɼ�=" + score + "]";
	}
	

}
