package com.example.demo.service;

import com.example.demo.dao.CommentDao;
import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.SecondComment;
import com.example.demo.model.Tie;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.demo.myenum.noticeEnum.NoticeCode.COMMENT_NOTICE;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserService userService;

    @Autowired
    private TieService tieService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private CommentService commentService;

    public ResultDTO doPublishComment(Comment comment){
        /*获取当前时间*/
        Date date = new Date();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        comment.setCommentTime(nowTime);
        /* 放入一级评论标志 */
        comment.setCommentTypes(0);
        commentDao.publishComment(comment);
        ResultDTO resultDTO = new ResultDTO();
        return  resultDTO.okOf("发送成功",comment);
    }

    public ResultDTO selectTeiComment(Integer tieId) {
        List<Comment> comments = commentDao.selectTeiComment(tieId,0);
        PageInfo pageInfo = new PageInfo(comments);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("获取成功",pageInfo);
    }

    public ResultDTO deleteTieComment(Integer commentId) {
        commentDao.deleteTieComment(commentId);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("删除评论成功");
    }

    public ResultDTO likeComment(Integer commentId) {
        Comment comment = commentDao.selectOneComment(commentId);
        Integer commentLikes = comment.getCommentLikes() + 1;
        commentDao.updateCommentLikes(commentId,commentLikes);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("点赞成功");
    }

    public ResultDTO notLikeComment(Integer commentId) {
        Comment comment = commentDao.selectOneComment(commentId);
        Integer commentLikes = comment.getCommentLikes() - 1;
        commentDao.updateCommentLikes(commentId,commentLikes);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("取消点赞成功");
    }

    public Comment selectCommentByReplyCommentId(Integer replyCommentId) {
        Comment comment = commentDao.selectCommentByReplyCommentId(replyCommentId);
        return comment;
    }

    public Comment selectByComplaintId(Integer complaintId) {
        Comment comment = commentDao.selectOneComment(complaintId);
        return comment;
    }

}
