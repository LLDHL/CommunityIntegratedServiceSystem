package com.example.demo.service;

import com.example.demo.dao.NotificationDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Comment;
import com.example.demo.model.Notification;
import com.example.demo.model.Tie;
import com.example.demo.model.User;
import com.example.demo.myenum.noticeEnum.NoticeCode;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.myenum.noticeEnum.NoticeCode.COMMENT_NOTICE;

@Service
public class NotificationService {

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private UserService userService;

    @Autowired
    private TieService tieService;

    public List<Notification> findNoticeByUserId(Integer id){
        List<Notification> noticeByReceiverId = notificationDao.findNoticeByReceiverId(id);
        return noticeByReceiverId;
    }

    public void setNoticeState(Integer noticeId,Integer status){
        notificationDao.setNoticeStatus(noticeId,status);
    }

    public Integer getReceiverIdByNoticeId(Integer noticeId){
        Notification notice = notificationDao.findNoticeByNoticeId(noticeId);
        return notice.getReceiverId();
    }

    public void deleteNoticeByNoticeId(Integer noticeId){
        notificationDao.deleteNotice(noticeId);
    }

    public void sendNotification(Integer notifierId,Integer receiverId,NoticeCode type ,String data){
        Notification notification = new Notification();
        notification.setNotifierId(notifierId);//系统通知id为0
        notification.setReceiverId(receiverId);
        notification.setType(type.getCode());
        notification.setGmt_create(System.currentTimeMillis());
        notification.setData(data);
        notificationDao.insertNotice(notification);
    }

}
