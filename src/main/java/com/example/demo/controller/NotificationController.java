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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/notification")
    public ResultDTO<List<Notification>> getAllNotice(HttpServletRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        List<Notification> noticeByUserId = notificationService.findNoticeByUserId(userId);
        return ResultDTO.okOf("用户通知列表", noticeByUserId);
    }

    //通知标记已读
    @PutMapping("/user/notification/{noticeId}")
    public ResultDTO<String> NoticeState(@PathVariable Integer noticeId, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        Integer receiverIdByNoticeId = notificationService.getReceiverIdByNoticeId(noticeId);
        if (userId.equals(receiverIdByNoticeId)) {//如果接收者确实是当前用户
            notificationService.setNoticeState(noticeId, 1);
            return ResultDTO.okOf();
        } else {
            return ResultDTO.errorOf(NOT_AUTHORITY);
        }
    }

    @DeleteMapping("/user/notification/{noticeId}")
    public ResultDTO<String> deleteNotice(@PathVariable Integer noticeId, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        Integer receiverIdByNoticeId = notificationService.getReceiverIdByNoticeId(noticeId);
        if (userId.equals(receiverIdByNoticeId)) {//如果接收者确实是当前用户
            notificationService.deleteNoticeByNoticeId(noticeId);
            return ResultDTO.okOf();
        } else {
            return ResultDTO.errorOf(NOT_AUTHORITY);
        }
    }
}
