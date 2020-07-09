package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.SecondComment;
import com.example.demo.model.Tie;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


import static com.example.demo.myenum.noticeEnum.NoticeCode.COMMENT_NOTICE;

@RestController
@RequestMapping("/user")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private SecondCommentService secondCommentService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TieService tieService;

    @Autowired
    private UserService userService;

    /* 发表一级评论 */
    @PostMapping("/first/comment")
    public ResultDTO doPublishComment(@RequestBody Comment comment){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        Tie tie = tieService.selectByTieId(comment.getTieId());
        Integer receiverId = tie.getUserId();
        notificationService.sendNotification(
                userId,
                receiverId,
                COMMENT_NOTICE,
                username +"评论了你：" + comment.getCommentContent());

        ResultDTO resultDTO = commentService.doPublishComment(comment);
        return resultDTO;
    }

    /* 查看一级评论 */
    @GetMapping("/first/comment/{tieId}")
    public ResultDTO tieComment(@PathVariable("tieId") Integer tieId){
        ResultDTO resultDTO = commentService.selectTeiComment(tieId);
        return resultDTO;
    }

    /* 删除一级评论,二级评论 */
    @DeleteMapping("/comment/{commentId}")
    public ResultDTO deDeleteTieComment(@PathVariable("commentId") Integer commentId){
        ResultDTO resultDTO = commentService.deleteTieComment(commentId);
        return resultDTO;
    }

    /*发布二级评论*/
    @PostMapping("/second/comment")
    public ResultDTO doPublishSecondComment(@RequestBody SecondComment secondComment){
        Authentication authentications = SecurityContextHolder.getContext().getAuthentication();
        String username = authentications.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);
        Integer replyCommentId = secondComment.getReplyCommentId();
        Comment comment = commentService.selectCommentByReplyCommentId(replyCommentId);
        notificationService.sendNotification(
                userId,
                comment.getCommentUserId(),
                COMMENT_NOTICE,
                username +"回复了你的评论：" + secondComment.getCommentContent());
        ResultDTO resultDTO = secondCommentService.doPublishSecondComment(secondComment);
        return resultDTO;
    }

    /* 查询一条评论的二级评论 */
    @GetMapping("/second/comment/{replyCommentId}")
    public ResultDTO doSelectSecondComment(@PathVariable("replyCommentId") Integer replyCommentId){
        ResultDTO resultDTO = secondCommentService.doSelectSecondComment(replyCommentId);
        return resultDTO;
    }

    /* 点赞一级评论 */
    @PutMapping("/like/comment/{commentId}")
    public ResultDTO doLikeComment(@PathVariable("commentId") Integer commentId) {
        ResultDTO resultDTO = commentService.likeComment(commentId);
        return resultDTO;
    }

    /* 取消点赞一级评论 */
    @PutMapping("/notLike/comment/{commentId}")
    public ResultDTO doNotLikeComment(@PathVariable("commentId") Integer commentId) {
        ResultDTO resultDTO = commentService.notLikeComment(commentId);
        return resultDTO;
    }
}
