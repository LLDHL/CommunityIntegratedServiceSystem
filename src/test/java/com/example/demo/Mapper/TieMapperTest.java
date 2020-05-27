package com.example.demo.Mapper;

import com.example.demo.model.Tie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void rememberBrowse(){
        tieMapper.rememberBrowse(20,5);
    }

}