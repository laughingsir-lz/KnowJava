package com.lz.practice_01;

/**
 * ѧ�������
 * @author zzz
 *
 */
public class StudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����5��student����
		Student student1 = new Student();
		student1.setNo("001");
		student1.setName("1�ſ���");
		student1.setScore(75);
		Student student2 = new Student();
		student2.setNo("002");
		student2.setName("2�ſ���");
		student2.setScore(76);
		Student student3 = new Student();
		student3.setNo("003");
		student3.setName("3�ſ���");
		student3.setScore(77);
		Student student4 = new Student();
		student4.setNo("004");
		student4.setName("4�ſ���");
		student4.setScore(78);
		Student student5 = new Student();
		student5.setNo("005");
		student5.setName("5�ſ���");
		student5.setScore(79);
		//��������students�洢student����
		Student[] students={student1,student2,student3,student4,student5};
		//���㵱ǰѧ���ǵ�ƽ���ɼ�
		System.out.println("ƽ���ɼ� ��"+Student.getAvg(students));
		//�������ѧ������Ϣ
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
	}

}
