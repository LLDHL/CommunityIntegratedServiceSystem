package com.example.demo.Mapper;

import com.example.demo.dao.TieDap;
import com.example.demo.model.Tie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TieDapTest {

    @Autowired
    private TieDap tieDap;

    @Test
    public void show(){
        Tie tie = tieDap.selectOneTie(5);
        System.out.println(tie);
    }

    @Test
    public void showOneAll(){
        List<Tie> ties = tieDap.selectPersonTie(1);
        System.out.println(ties);
    }

    @Test
    public void rememberBrowse(){
        tieDap.rememberBrowse(20,5);
    }

}