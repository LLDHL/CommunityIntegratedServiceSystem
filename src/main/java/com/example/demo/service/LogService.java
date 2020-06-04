package com.example.demo.service;

import com.example.demo.dao.AdminOperateLogDao;
import com.example.demo.model.AdminOperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private AdminOperateLogDao adminOperateLogDao;

    public List<AdminOperateLog> findAllLog(){
        return adminOperateLogDao.findAllLog();
    }
    public List<AdminOperateLog> findLogByAdminId(Integer adminId){
        return adminOperateLogDao.findLogByAdminId(adminId);
    }
    public AdminOperateLog findByOperateId(Integer operateId){
        return adminOperateLogDao.findByOperateId(operateId);
    }

}
