package com.lz.practice_01;

/**
 * 学生类测试
 * @author zzz
 *
 */
public class StudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建5个student对象
		Student student1 = new Student();
		student1.setNo("001");
		student1.setName("1号考生");
		student1.setScore(75);
		Student student2 = new Student();
		student2.setNo("002");
		student2.setName("2号考生");
		student2.setScore(76);
		Student student3 = new Student();
		student3.setNo("003");
		student3.setName("3号考生");
		student3.setScore(77);
		Student student4 = new Student();
		student4.setNo("004");
		student4.setName("4号考生");
		student4.setScore(78);
		Student student5 = new Student();
		student5.setNo("005");
		student5.setName("5号考生");
		student5.setScore(79);
		//对象数组students存储student对象
		Student[] students={student1,student2,student3,student4,student5};
		//计算当前学生们的平均成绩
		System.out.println("平均成绩 ："+Student.getAvg(students));
		//输出所有学生的信息
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
	}

}
