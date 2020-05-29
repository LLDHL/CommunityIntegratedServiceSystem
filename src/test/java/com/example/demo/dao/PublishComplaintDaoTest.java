package com.example.demo.dao;

import com.example.demo.model.PublishComplaint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PublishComplaintDaoTest {

    @Autowired
    private PublishComplaintDao publishComplaintDao;

    @Test
    void updateMyComplaint() {
        PublishComplaint publishComplaint = new PublishComplaint();
        publishComplaint.setComplaintId(1);
        publishComplaint.setComplaintContent("垃圾太多");
        publishComplaintDao.updateMyComplaint(publishComplaint);
    }
}