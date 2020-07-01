package com.lz.test;

import org.junit.Test;
import com.lz.web.user.UserDaoImpl;
/**
 * @ClassName UserDaoTest
 * @Description:
 * @Author: zzz
 **/
public class UserDaoTest {
    //包含需要测试的类
    private UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void testAdd(){
        System.out.println(userDao.add(1, 2));

    }
    @Test
    public void testDelete(){
        userDao.delete(3);
    }
}

