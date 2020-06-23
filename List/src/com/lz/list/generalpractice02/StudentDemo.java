package com.lz.list.generalpractice02;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * @ClassName StudentDemo
 * @Description: 学生类测试
 * @Author: zzz
 **/
public class StudentDemo {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        //组装学生对象数据
        Student student1 = new Student("Tom",18,100,"class05");
        Student student2 = new Student("Jerry",22,70,"class04");
        Student student3 = new Student("Owen",25,90,"class05");
        Student student4 = new Student("Jim",30,80,"class05");
        Student student5 = new Student("Steve",28,66,"class06");
        Student student6 = new Student("Kevin",24,100,"class04");
        //创建ArrayList对象 studentList 泛型指定为tudent
        ArrayList<Student> studentList = new ArrayList<>();
        //添加学生数据
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        System.out.println(studentList);
        //修改Jerry的成绩将70修改为90。
        for (Student student : studentList) {
            if(student.getName().equals("Jerry")){
                student.setScore(90);
            }
        }
        System.out.println(studentList);
        //删除Kevin这一条学生数据。
        //普通for循环，删除一条数据，能够成功删除，但是遍历会漏掉一条紧随其后的数据
//        for (int i=0;i<studentList.size();i++) {
////            if (studentList.get(i).getName().equals("Kevin")){
//                studentList.remove(i);
////            }
//        }
        //for循环中完成多次删除，会出现并发修改错误
//        for (Student student : studentList) {
//            studentList.remove(student);
//        }
        //在迭代器中完成删除是循环删除最保险的
        Iterator<Student> it = studentList.iterator();
        while(it.hasNext()){
            String x = it.next().getName();
            if(x.equals("Kevin")){
                it.remove();
            }
        }
        System.out.println(studentList);
        //计算class05班级学生的平均分
        for (Student student : studentList) {
            if(student.getClassNum().equals("class05")){
                sum += student.getScore();
                count++;
            }
        }
        System.out.println("class05班级学生平均成绩为 "+(double)(sum/count));
    }

}
