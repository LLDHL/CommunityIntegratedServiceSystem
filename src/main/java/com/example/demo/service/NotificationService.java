package com.example.demo.service;

import com.example.demo.dao.NotificationDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Notification;
import com.example.demo.model.User;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationDao notificationDao;

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
}
