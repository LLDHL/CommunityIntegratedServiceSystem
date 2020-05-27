package com.example.demo.service;

import com.example.demo.dao.AuthstrDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public AuthstrDao authstrDao;
    @Autowired
    public UserDao userDao;

    public void userRegister(User user){
        authstrDao.insertUser(user);
    }

    //管理员填写审核意见返回给用户
    public void adminAuthstr(boolean result,String message){

    }

    public void handler(){

    }
}
