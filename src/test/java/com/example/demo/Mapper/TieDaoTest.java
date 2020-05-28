package com.example.demo.Mapper;

import com.example.demo.dao.TieDao;
import com.example.demo.model.Tie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TieDaoTest {

    @Autowired
    private TieDao tieDao;

    @Test
    public void show(){
        Tie tie = tieDao.selectOneTie(5);
        System.out.println(tie);
    }

    @Test
    public void showOneAll(){
        List<Tie> ties = tieDao.selectPersonTie(1);
        System.out.println(ties);
    }

    @Test
    public void rememberBrowse(){
        tieDao.rememberBrowse(20,5);
    }

}