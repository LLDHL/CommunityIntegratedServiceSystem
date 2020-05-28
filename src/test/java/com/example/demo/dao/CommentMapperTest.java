package com.example.demo.dao;

import com.example.demo.model.SecondComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentMapperTest {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void test1(){
        commentMapper.deleteTieComment(16);
    }

    @Test
    public void test2(){
        List<SecondComment> secondComments = commentMapper.doSelectSecondComment(12, 1);
        System.out.println(secondComments);
    }

}