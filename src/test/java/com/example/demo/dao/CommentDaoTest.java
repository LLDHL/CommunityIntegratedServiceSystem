package com.example.demo.dao;

import com.example.demo.model.Comment;
import com.example.demo.model.SecondComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void test1(){
        commentDao.deleteTieComment(16);
    }

    @Test
    public void test2(){
        List<SecondComment> secondComments = commentDao.doSelectSecondComment(12, 1);
        System.out.println(secondComments);
    }

    @Test
    public void test3(){
        Comment comment = commentDao.selectOneComment(1);
        System.out.println(comment);
    }

    @Test
    public void test4(){
        commentDao.updateCommentLikes(1,0);
    }

}