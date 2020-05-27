package com.example.demo.Mapper;

import com.example.demo.model.Tie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TieMapperTest {

    @Autowired
    private TieMapper tieMapper;

    @Test
    public void show(){
        Tie tie = tieMapper.selectOneTie(5);
        System.out.println(tie);
    }

    @Test
    public void showOneAll(){
        List<Tie> ties = tieMapper.selectPersonTie(1);
        System.out.println(ties);
    }

    @Test
    public void rememberBrowse(){
        tieMapper.rememberBrowse(20,5);
    }

}