package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Repair;
import com.example.demo.service.OkRepairServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/okRepair")
public class OkRepairController {

    @Autowired
    private OkRepairServer okRepairServer;

    /* 查询未修理的报修 */
    @GetMapping("/selectNoRepair/{page}/{size}")
    public ResultDTO doSelectNoRepair(@PathVariable("page") Integer page,
                                      @PathVariable("size") Integer size){
        ResultDTO resultDTO = okRepairServer.doSelectNoRepair(page, size);
        return resultDTO;
    }

    /* 接单，去维修 */
    @PutMapping("/acceptRepair/{repairId}")
    public ResultDTO acceptRepair(@PathVariable("repairId") Integer repairId,
                                  @RequestBody Repair repair){
        /*获取当前时间*/
        Date date = new Date();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        repair.setRepairStatus("等待师傅上门维修");
        repair.setOkRepairTime(nowTime);
        repair.setRepairId(repairId);
        ResultDTO resultDTO = okRepairServer.doAcceptRepair(repair, repairId);
        return resultDTO;
    }

    /* 查询已接维护 */
    @GetMapping("/selectAcceptRepair/{okRepairUserId}/{page}/{size}")
    public ResultDTO doSelectAcceptRepair(@PathVariable("okRepairUserId") Integer okRepairUserId,
                                          @PathVariable("page") Integer page,
                                          @PathVariable("size") Integer size){

        ResultDTO resultDTO = okRepairServer.doSelectAcceptRepair(okRepairUserId, page, size);
        return resultDTO;
    }
}
