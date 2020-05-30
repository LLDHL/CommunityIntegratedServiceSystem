package com.example.demo.controller;


import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Repair;
import com.example.demo.service.RepairService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    /* 用户报修发布 */
    @PostMapping("/publishRepair")
    public ResultDTO doPublishRepair(@RequestBody Repair repair){
        ResultDTO resultDTO = repairService.publishRepair(repair);
        return resultDTO;
    }

    /* 用户报修删除 */
    @DeleteMapping("/deleteRepair/{repairId}")
    public ResultDTO doDeleteRepair(@PathVariable("repairId") Integer repairId){
        ResultDTO resultDTO = repairService.deleteRepair(repairId);
        return resultDTO;
    }

    /* 完成维修后用户修改状态 */
    @PutMapping("/finishedRepair/{repairId}")
    public ResultDTO repairFinish(@PathVariable("repairId") Integer repairId){
        ResultDTO resultDTO = repairService.repairFinished(repairId);
        return resultDTO;
    }

    /* 查看自己所有的报修记录 */
    @GetMapping("/selectMyRepair/{repairUserId}/{page}/{num}")
    public ResultDTO selectMyRepair(@PathVariable("repairUserId") Integer repairUserId,
                                    @PathVariable("page") Integer page,
                                    @PathVariable("num") Integer num){
        ResultDTO resultDTO = repairService.doSelectMyRepair(repairUserId, page, num);
        return resultDTO;
    }

}
