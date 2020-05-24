package com.example.demo.dao;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void insertUser() {
        User user =new User();
        user.setName("插入测试");
        userDao.insertUser(user);
    }

    @Test
    void updateUser() {
        User user =new User();
        user.setName("插入测试");
        user.setAddress("更新测试");
        userDao.updateUser(user);
    }

    @Test
    void findUserByUserId() {
        userDao.findUserByUserId(2);
    }

    @Test
    void findUserByUserName() {
        userDao.findUserByUserName("插入测试");
    }

    @Test
    void deleteUser() {
        userDao.deleteUser(2);
    }
}