package com.example.demo.service;

import com.example.demo.dao.RepairDao;
import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Repair;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OkRepairServer {

    @Autowired
    private RepairDao repairDao;

    public ResultDTO doSelectNoRepair(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Repair> repairs = repairDao.doSelectNoRepair();
        PageInfo pageInfo = new PageInfo(repairs);
        return ResultDTO.okOf("获取成功",pageInfo);
    }

    public ResultDTO doAcceptRepair(Repair repair, Integer repairId) {
        repairDao.doAcceptRepair(repair);
        return ResultDTO.okOf("接单成功",repair);
    }

    public ResultDTO doSelectAcceptRepair(Integer okRepairUserId, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Repair> repairs = repairDao.doSelectAcceptRepair(okRepairUserId);
        PageInfo pageInfo = new PageInfo(repairs);
        return ResultDTO.okOf("获取成功",pageInfo);
    }
}
