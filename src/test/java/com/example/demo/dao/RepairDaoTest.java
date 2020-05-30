package com.example.demo.dao;

import com.example.demo.model.Repair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepairDaoTest {

    @Autowired
    private RepairDao repairDao;

    @Test
    void publishRepair() {
        Repair repair = new Repair();
        repair.setRepairUserId(1);
        repair.setRepairUsername("lzy");
        repair.setCommunityId(101);
        repair.setRepairContent("水管坏了");
        repair.setRepairPicture("D://a.jpg");
        repair.setHomeId("56栋1801");
        repair.setRepairPhone("13202792608");
        repair.setRepairEmail("qwe@qq.com");
        repair.setRepairTime("2020-5-28");
        repairDao.publishRepair(repair);
    }
}