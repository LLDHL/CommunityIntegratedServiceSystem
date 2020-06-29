package com.example.demo.controller;


import com.example.demo.dao.TieDao;
import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.Complaint;
import com.example.demo.model.RespondComplaint;
import com.example.demo.service.CommentService;
import com.example.demo.service.NotificationService;
import com.example.demo.service.RespondComplaintService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.myenum.noticeEnum.NoticeCode.COMMENT_NOTICE;


@RestController
@RequestMapping("/pmcAdmin")
public class RespondComplaintController {

    @Autowired
    private RespondComplaintService respondComplaintService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TieDao tieDao;

    /* 跟进投诉建议 */
    @PutMapping("/complaint/{complaintId}")
    public ResultDTO doRespondComplaintByComplaintId(@PathVariable("complaintId") Integer complaintId,
                                                     @RequestBody RespondComplaint respondComplaint){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);
        Complaint result = respondComplaintService.selectByComplaintId(complaintId);
        notificationService.sendNotification(
                userId,
                result.getUserId(),
                COMMENT_NOTICE,
                username + "已经收到您的投诉建议，请等待联系");

        ResultDTO resultDTO = respondComplaintService.respondComplainByComplaintId(respondComplaint,complaintId);
        return resultDTO;
    }

    /* 查询自己跟进过的投诉建议 */
    @GetMapping("/complaint/{respondComplaintUserId}")
    public ResultDTO doSelectMyRespondComplaint(@PathVariable("respondComplaintUserId") Integer respondComplaintUserId,
                                                @RequestParam(name = "page",defaultValue = "1") Integer page,
                                                @RequestParam(name = "size",defaultValue = "5") Integer size){
        ResultDTO resultDTO = respondComplaintService.selectMyRespondComplaint(respondComplaintUserId, page, size);
        return resultDTO;
    }

    /* 查询还未跟进的投诉建议 */
    @GetMapping("/not/complaint")
    public ResultDTO doSelectNoRespondComplaint( @RequestParam(name = "page",defaultValue = "1") Integer page,
                                                 @RequestParam(name = "size",defaultValue = "5") Integer size){
        ResultDTO resultDTO = respondComplaintService.selectNoRespondComplaint(page,size);
        return resultDTO;
    }
}
