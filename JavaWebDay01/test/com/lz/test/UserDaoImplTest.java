package com.lz.test;

import com.lz.web.user.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
 private UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void add() {
        System.out.println(userDao.add(2, 2));
    }

    @Test
    public void delete() {
        userDao.delete(1);
    }
}