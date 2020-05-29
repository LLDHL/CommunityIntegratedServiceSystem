package com.example.demo.controller;


import com.example.demo.dto.ResultDTO;
import com.example.demo.model.RespondComplaint;
import com.example.demo.service.RespondComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respondComplaint")
public class RespondComplaintController {

    @Autowired
    private RespondComplaintService respondComplaintService;

    /* 跟进投诉建议 */
    @PutMapping("/doRespondComplaintByComplaintId/{complaintId}")
    public ResultDTO doRespondComplaintByComplaintId(@PathVariable("complaintId") Integer complaintId,
                                                     @RequestBody RespondComplaint respondComplaint){
        ResultDTO resultDTO = respondComplaintService.respondComplainByComplaintId(respondComplaint, complaintId);
        return resultDTO;
    }

    /* 查询自己跟进过的投诉建议 */
    @GetMapping("/doSelectMyRespondComplaint/{respondComplaintUserId}/{page}/{size}")
    public ResultDTO doSelectMyRespondComplaint(@PathVariable("respondComplaintUserId") Integer respondComplaintUserId,
                                       @PathVariable("page") Integer page,
                                       @PathVariable("size") Integer size){
        ResultDTO resultDTO = respondComplaintService.selectMyRespondComplaint(respondComplaintUserId, page, size);
        return resultDTO;
    }

    /* 查询还未跟进的投诉建议 */
    @GetMapping("/doSelectNoRespondComplaint/{page}/{size}")
    public ResultDTO doSelectNoRespondComplaint(@PathVariable("page") Integer page,
                                                @PathVariable("size") Integer size){
        ResultDTO resultDTO = respondComplaintService.selectNoRespondComplaint(page,size);
        return resultDTO;
    }
}
