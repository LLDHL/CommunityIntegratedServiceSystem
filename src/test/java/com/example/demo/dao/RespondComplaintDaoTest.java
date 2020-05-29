package com.example.demo.dao;

import com.example.demo.model.RespondComplaint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RespondComplaintDaoTest {

    @Autowired
    private RespondComplaintDao respondComplaintDao;


    @Test
    public void doRespond(){
        RespondComplaint respondComplaint = new RespondComplaint();
        respondComplaint.setRespondComplaintUserId(445);
        respondComplaint.setRespondComplaintUsername("小区物业101员工");
        respondComplaint.setRespondComplaintContent("已联系当事人，问题完美解决");
        respondComplaint.setRespondComplaintTime(null);
        respondComplaint.setRespondComplaintAuthority("管理员");
        respondComplaintDao.respondComplaintByComplaintId(respondComplaint);
        respondComplaintDao.updateComplaintStatusByComplaintId("已有人处理",1);
    }

    @Test
    public void doGet(){
        respondComplaintDao.selectNoRespondComplaint();
    }



}