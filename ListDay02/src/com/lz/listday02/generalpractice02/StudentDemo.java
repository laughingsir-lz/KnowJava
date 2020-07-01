package com.lz.listday02.generalpractice02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName StudentDemo
 * @Description:
 * @Author: zzz
 **/
public class StudentDemo {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        //组装学生对象数据
        Student student1 = new Student("Tom", 18, 100, "class05");
        Student student2 = new Student("Jerry", 22, 70, "class04");
        Student student3 = new Student("Owen", 25, 90, "class05");
        Student student4 = new Student("Jim", 30, 80, "class05");
        Student student5 = new Student("Steve", 28, 66, "class06");
        Student student6 = new Student("Kevin", 24, 100, "class04");
        //stuSet 集合
        Set<Student> stuSet = new HashSet<>();
        stuSet.add(student1);
        stuSet.add(student2);
        stuSet.add(student3);
        stuSet.add(student4);
        stuSet.add(student5);
        stuSet.add(student6);
        //修改Jerry的成绩将70修改为90。
        for (Student student : stuSet) {
            if (student.getName().equals("Jerry")) {
                student.setScore(90);
            }
        }
        System.out.println(stuSet);
        //删除Kevin这一条学生数据。
        //迭代器删除  保证安全 使用迭代器的remove方法
        Iterator<Student> iterator = stuSet.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            if (next.getName().equals("Kevin")) {
                iterator.remove();
            }
        }
        System.out.println(stuSet);

        //计算class05班级学生的平均分
        for (Student student : stuSet) {
            if (student.getClassNum().equals("class05")) {
                sum += student.getScore();
                count++;
            }
        }
        System.out.println("class05班级学生平均成绩为 " + (double) (sum / count));
    }
}
