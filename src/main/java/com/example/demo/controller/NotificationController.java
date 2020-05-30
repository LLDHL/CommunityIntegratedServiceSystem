package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Notification;
import com.example.demo.service.NotificationService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

import static com.example.demo.exception.CustomErrorCode.NOT_AUTHORITY;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/allNotice/{userId}")
    public ResultDTO<List<Notification>> getAllNotice(@PathVariable Integer userId, HttpServletRequest request){
        Principal userPrincipal = request.getUserPrincipal();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId1 = userService.getUserId(username);

        if (userId.equals(userId1)){//判断当前登录的用户id和要查询的用户id是否一致
            List<Notification> noticeByUserId = notificationService.findNoticeByUserId(userId);
            return ResultDTO.okOf("用户通知列表",noticeByUserId);
        }else {
            return ResultDTO.errorOf(NOT_AUTHORITY);
        }
    }

    @GetMapping("/user/noticeRead/{noticeId}")
    public ResultDTO<String> NoticeState(@PathVariable Integer noticeId, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        Integer receiverIdByNoticeId = notificationService.getReceiverIdByNoticeId(noticeId);
        if (userId.equals(receiverIdByNoticeId)){//如果接收者确实是当前用户
            notificationService.setNoticeState(noticeId,1);
            return ResultDTO.okOf();
        }else {
            return ResultDTO.errorOf(NOT_AUTHORITY);
        }
    }

    @DeleteMapping("/user/deleteNotice/{noticeId}")
    public ResultDTO<String> deleteNotice(@PathVariable Integer noticeId, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        Integer receiverIdByNoticeId = notificationService.getReceiverIdByNoticeId(noticeId);
        if (userId.equals(receiverIdByNoticeId)){//如果接收者确实是当前用户
            notificationService.deleteNoticeByNoticeId(noticeId);
            return ResultDTO.okOf();
        }else {
            return ResultDTO.errorOf(NOT_AUTHORITY);
        }
    }
}
