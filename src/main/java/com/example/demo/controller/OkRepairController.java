package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.Repair;
import com.example.demo.model.Tie;
import com.example.demo.service.NotificationService;
import com.example.demo.service.OkRepairServer;
import com.example.demo.service.RepairService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.demo.myenum.noticeEnum.NoticeCode.COMMENT_NOTICE;

@RestController
@RequestMapping("/worker")
public class OkRepairController {

    @Autowired
    private OkRepairServer okRepairServer;

    @Autowired
    private RepairService repairService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;



    /* 查询未修理的报修 */
    @GetMapping("/not/repair")
    public ResultDTO doSelectNoRepair(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                      @RequestParam(name = "size",defaultValue = "5") Integer size){
        ResultDTO resultDTO = okRepairServer.doSelectNoRepair(page-1, size);
        return resultDTO;
    }

    /* 接单，去维修 */
    @PutMapping("/repair/{repairId}")
    public ResultDTO acceptRepair(@PathVariable("repairId") Integer repairId,
                                  @RequestBody Repair repair){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);
        Repair result = repairService.findByUserId(userId);

        notificationService.sendNotification(
                userId,
                result.getRepairUserId(),
                COMMENT_NOTICE,
                username + " 已经接单，会尽快联系您！");


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
    @GetMapping("/yes/repair/{okRepairUserId}")
    public ResultDTO doSelectAcceptRepair(@PathVariable("okRepairUserId") Integer okRepairUserId,
                                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                                          @RequestParam(name = "size",defaultValue = "5") Integer size){

        ResultDTO resultDTO = okRepairServer.doSelectAcceptRepair(okRepairUserId, page-1, size);
        return resultDTO;
    }
}
