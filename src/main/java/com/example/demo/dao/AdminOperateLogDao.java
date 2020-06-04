package com.example.demo.dao;

import com.example.demo.model.AdminOperateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminOperateLogDao {
    void insertLog(AdminOperateLog adminOperateLog);
    List<AdminOperateLog> findAllLog();
    List<AdminOperateLog> findLogByAdminId(Integer adminId);
    AdminOperateLog findByOperateId(Integer operateId);
}
