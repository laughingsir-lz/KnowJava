package com.lz.daopass.dao.impl;

import com.lz.daopass.dao.IStudentDAO;
import com.lz.daopass.domain.Student;
import com.lz.jdbc.DriverDemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentDAOImpl
 * @Description:
 * @Author: zzz
 **/
public class StudentDAOImpl implements IStudentDAO {
    private DriverDemo driverDemo = new DriverDemo();
    //private Student student = new Student();

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO student(name,email,age) VALUES ('" + student.getName() + "','" + student.getEmail() + "'," + student.getAge() + ")";
        Connection conn = null;
        Statement st = null;
        try {
            //获取连接对象
            conn = driverDemo.getDriver();
            //获取语句对象
            st = conn.createStatement();
            //执行sql语句
            st.executeUpdate(sql);
            //st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insert2(Student student) {
        String sql = "INSERT INTO student(name,email,age) VALUES (?,?,?)";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            //获取连接对象
            conn = driverDemo.getDriver();
            //获取预编译语句对象
            pst = conn.prepareStatement(sql);
            //给占位符？ 设置值
            pst.setObject(1,student.getName());
            pst.setObject(2,student.getEmail());
            pst.setObject(3,student.getAge());
            //执行sql语句
            pst.executeUpdate();
            //pst.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String delete(Long id) {
        String sql = "DELETE FROM student WHERE id=?";
        int ret = 0;
        Connection conn = null;
        PreparedStatement pst= null;
        try {
            conn = driverDemo.getDriver();
            pst = conn.prepareStatement(sql);
            //给？设值
            pst.setLong(1,id);
            ret= pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pst!= null){
                    pst.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if (conn!= null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return ret!=0? "删除成功":"删除失败";
    }

    @Override
    public String update(Student student) {
        String sql = "UPDATE student SET name=?,email=?,age=? WHERE id=?";
        int ret= 0;
        Connection conn = null;
        PreparedStatement pst= null;
        try {
             conn = driverDemo.getDriver();
             pst = conn.prepareStatement(sql);
             pst.setString(1,student.getName());
             pst.setString(2,student.getEmail());
             pst.setInt(3,student.getAge());
             pst.setLong(4,student.getId());
             ret= pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pst!= null){
                    pst.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if (conn!= null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return ret>0? "修改成功":"修改失败";
    }

    @Override
    public Student selectOne(long id) {
        String sql = "SELECT * FROM student WHERE id=?";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = driverDemo.getDriver();
            pst = conn.prepareStatement(sql);
            pst.setLong(1,id);
            rs = pst.executeQuery();
            //从结果集rs中获取数据
            if (rs.next()) {
                long resultId = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                Student student = new Student(name,email,age,resultId);
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
       // return new Student("查无此人","查无此人",0);'
        return null;
    }

    @Override
    public List<Student> selectList() {
        //用list集合来保存返回的学生对象信息
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student ";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = driverDemo.getDriver();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //从结果集rs中获取数据
           while (rs.next()) {
                long resultId = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                Student student = new Student(name,email,age,resultId);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }
}
