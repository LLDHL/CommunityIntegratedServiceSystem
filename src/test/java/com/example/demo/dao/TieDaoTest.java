package com.example.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TieDaoTest {

    @Autowired
    private TieDao tieDao;

    @Test
    public void test01(){
        System.out.println(tieDao.selectOneTie(55));
    }

}