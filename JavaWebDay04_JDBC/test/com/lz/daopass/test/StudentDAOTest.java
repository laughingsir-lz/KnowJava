package com.lz.daopass.test;

import com.lz.daopass.dao.IStudentDAO;
import com.lz.daopass.dao.impl.StudentDAOImpl;
import com.lz.daopass.domain.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOTest {
private IStudentDAO iStudentDAO =new StudentDAOImpl();
    @Test
    public void insert(){
        Student student = new Student("www","www@email",45);
        iStudentDAO.insert(student);
    }
    @Test
    public void insert2(){
        Student student = new Student("oop","oop@email",45);
        iStudentDAO.insert(student);
    }
    @Test
    public void update(){
        Student student = new Student("乱码改正修改","xiaopan@email",18,35l);
        System.out.println(iStudentDAO.update(student));
    }
    @Test
    public void delete(){
        System.out.println(iStudentDAO.delete(20l));
    }
    @Test
    public void selectOne(){
        System.out.println(iStudentDAO.selectOne(12l));
    }
    @Test
    public void selectList(){
//        Iterator<Student> iterator = iStudentDAO.selectList().iterator();
//        while (iterator.hasNext()){
//            Student student = iterator.next();
//            System.out.println(student);
//        }
        List<Student> students = iStudentDAO.selectList();
     students.forEach(student -> System.out.println(student));

    }
    public void  testIt(){
        List<String> list = Arrays.asList("a","b","c","d");
        Iterator<String> it =list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}