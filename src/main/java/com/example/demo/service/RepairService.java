package com.example.demo.service;

import com.example.demo.dao.RepairDao;
import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Repair;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RepairService {

    @Autowired
    private RepairDao repairDao;

    public ResultDTO publishRepair(Repair repair){
        /*获取当前时间*/
        Date date = new Date();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        repair.setRepairTime(nowTime);
        repair.setRepairStatus("等待维修人员联系");
        repairDao.publishRepair(repair);
        return ResultDTO.okOf("发表成功",repair);
    }

    public ResultDTO deleteRepair(Integer repairId) {
        repairDao.deleteRepair(repairId);
        return ResultDTO.okOf("已删除",repairId);
    }

    public ResultDTO repairFinished(Integer repairId) {
        String finish = "完成维修";
        repairDao.updateRepairStatus(repairId,finish);
        return ResultDTO.okOf("已完成维修",repairId);
    }

    public ResultDTO doSelectMyRepair(Integer repairUserId, Integer page, Integer num) {
        PageHelper.startPage(page,num);
        List<Repair> repairs = repairDao.doSelectMyRepair(repairUserId);
        PageInfo pageInfo = new PageInfo(repairs);
        return ResultDTO.okOf("查询成功",pageInfo);
    }

    public boolean findRepairByUserId(Integer userId) {
        Repair repairUser = repairDao.findRepairUserId(userId);
        if (repairUser.getRepairUserId() != userId){
            return false;
        }
        return true;
    }

    public boolean findRepairByRepairId(Integer repairId, Integer userId) {
        Repair repair = repairDao.findRepairByRepairId(repairId);
        if ((repair.getRepairUserId()).equals(userId)){
            return true;
        }else {
            return false;
        }
    }

    public Repair findByUserId(Integer userId) {
        Repair repair = repairDao.findRepairByRepairId(userId);
        return repair;
    }
}
