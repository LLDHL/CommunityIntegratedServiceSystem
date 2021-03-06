package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.PublishComplaint;
import com.example.demo.service.PublishComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class PublishComplaintController {

    @Autowired
    private PublishComplaintService publishComplaintService;

    /* 发表投诉 */
    @PostMapping("/complaint")
    public ResultDTO doPublishRealNameComplaint(@RequestBody PublishComplaint publishComplaint){
        ResultDTO resultDTO = publishComplaintService.publishComplaint(publishComplaint);
        return resultDTO;
    }

    /* 查看我发表的投诉 */
    @GetMapping("/complaint/{userId}")
    public ResultDTO doSelectComplaint(@PathVariable("userId") Integer userId,
                                       @RequestParam(name = "page",defaultValue = "1") Integer page,
                                       @RequestParam(name = "size",defaultValue = "5") Integer size
                                       ){
        ResultDTO resultDTO = publishComplaintService.selectMyComplaint(userId, page, size);
        return resultDTO;
    }

    /* 查看小区所有投诉 */
    @GetMapping("/community/complaint/{communityId}")
    public ResultDTO doSelectCommunityComplaint(@PathVariable("communityId") Integer communityId,
                                                @RequestParam(name = "page",defaultValue = "1") Integer page,
                                                @RequestParam(name = "size",defaultValue = "5") Integer size){
        ResultDTO resultDTO = publishComplaintService.selectCommunityComplaint(communityId, page, size);
        return resultDTO;
    }

    /* 修改投诉建议 */
    @PutMapping("/complaint/{complaintId}")
    public ResultDTO doUpdateMyComplaint(@PathVariable("complaintId") Integer complaintId,
                                         @RequestBody PublishComplaint publishComplaint){
        ResultDTO resultDTO = publishComplaintService.updateMyComplaint(complaintId, publishComplaint);
        return resultDTO;
    }

    /* 删除投诉建议 */
    @DeleteMapping("/complaint/{complaintId}")
    public ResultDTO doDeleteMyComplaint(@PathVariable("complaintId") Integer complaintId){
        ResultDTO resultDTO = publishComplaintService.deleteMyComplaint(complaintId);
        return resultDTO;
    }
}
