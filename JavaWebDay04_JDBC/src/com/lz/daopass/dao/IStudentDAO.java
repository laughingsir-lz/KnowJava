package com.lz.daopass.dao;

import com.lz.daopass.domain.Student;
import java.util.List;

/**
 * @ClassName IStudentDAO
 * @Description: DAO 接口,设计 DAO 接口方法 (dao/IStudentDAO)
 * @Author: zzz
 **/
public interface IStudentDAO {
    /**
     * 插入方法
     * @param  student 学生对象
     */
    void insert(Student student);

    /**
     * insert方法的优化
     * @param student
     */
    void insert2(Student student);

    /**
     * 删除方法
     * @param id
     * @return 删除成功与否
     */
    String delete(Long id);

    /**
     * 修改一条数据
     * @param  student
     * @return  修改成功与否
     */
    String update(Student student);

    /**
     * 查询一条数据
     * @param  id
     * @return 返回一个学生对象
     */
    Student selectOne(long id);

    /**
     * 查询多条数据
     *
     * @return 返回学生信息集合
     */
    List<Student> selectList();


}
