package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthstrDao {

    void insertUser(User user);
    void updateUser(User user);
    User findUserByUserId(Integer id);
    User findUserByUserName(String name);
    void deleteUser(Integer id);
}
