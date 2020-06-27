package com.example.demo.controller;


import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Repair;
import com.example.demo.service.RepairService;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @Autowired
    private UserService userService;

    /* 用户报修发布 */
    @PostMapping("/repair")
    public ResultDTO doPublishRepair(@RequestBody Repair repair){
        ResultDTO resultDTO = repairService.publishRepair(repair);
        return resultDTO;
    }

    /* 用户报修删除 */
    @DeleteMapping("/repair/{repairId}")
    public ResultDTO doDeleteRepair(@PathVariable("repairId") Integer repairId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        if(repairService.findRepairByRepairId(repairId,userId)){
            ResultDTO resultDTO = repairService.deleteRepair(repairId);
            return resultDTO;
        }else{
            return ResultDTO.errorOf(401,"你无权这么做");
        }
    }

    /* 完成维修后用户修改状态 */
    @PutMapping("/repair/ok/{repairId}")
    public ResultDTO repairFinish(@PathVariable("repairId") Integer repairId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        if(repairService.findRepairByRepairId(repairId,userId)){
            ResultDTO resultDTO = repairService.repairFinished(repairId);
            return resultDTO;
        }else{
            return ResultDTO.errorOf(401,"你无权这么做");
        }
    }

    /* 查看自己所有的报修记录 */
    @GetMapping("/repair/{repairUserId}")
    public ResultDTO selectMyRepair(@PathVariable("repairUserId") Integer repairUserId,
                                    @RequestParam(name = "page",defaultValue = "1") Integer page,
                                    @RequestParam(name = "size",defaultValue = "5") Integer size){
        ResultDTO resultDTO = repairService.doSelectMyRepair(repairUserId, page, size);
        return resultDTO;
    }

}
