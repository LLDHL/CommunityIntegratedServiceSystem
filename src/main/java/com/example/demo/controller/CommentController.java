package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.SecondComment;
import com.example.demo.service.CommentService;
import com.example.demo.service.SecondCommentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private SecondCommentService secondCommentService;

    /* 发表一级评论 */
    @PostMapping("/doPublishComment")
    public ResultDTO doPublishComment(@RequestBody Comment comment){
        ResultDTO resultDTO = commentService.doPublishComment(comment);
        return resultDTO;
    }

    /* 查看一级评论 */
    @GetMapping("selectTieComment/{tieId}")
    public ResultDTO doSelectTieComment(@PathVariable("tieId") Integer tieId){
        ResultDTO resultDTO = commentService.selectTeiComment(tieId);
        return resultDTO;
    }

    /* 删除一级评论,二级评论 */
    @DeleteMapping("deleteTieComment/{commentId}")
    public ResultDTO deDeleteTieComment(@PathVariable("commentId") Integer commentId){
        ResultDTO resultDTO = commentService.deleteTieComment(commentId);
        return resultDTO;
    }

    /*发布二级评论*/
    @PostMapping("/doPublishSecondComment")
    public ResultDTO doPublishSecondComment(@RequestBody SecondComment secondComment){
        ResultDTO resultDTO = secondCommentService.doPublishSecondComment(secondComment);
        return resultDTO;
    }

    /* 查询一条评论的二级评论 */
    @GetMapping("/selectSecondComment/{replyCommentId}")
    public ResultDTO doSelectSecondComment(@PathVariable("replyCommentId") Integer replyCommentId){
        ResultDTO resultDTO = secondCommentService.doSelectSecondComment(replyCommentId);
        return resultDTO;
    }
}
