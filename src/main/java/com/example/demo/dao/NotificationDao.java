package com.example.demo.dao;

import com.example.demo.model.Notification;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationDao {
    void insertNotice(Notification notification);
    void updateNotice(Notification notification);
    Notification findNoticeByNoticeId(Integer noticeId);
    List<Notification> findNoticeByReceiverId(Integer ReceiverId);
    void deleteNotice(Integer noticeId);
    void setNoticeStatus(Integer noticeId,Integer status);
//    Integer getReceiverIdByNoticeId(Integer noticeId);
}
