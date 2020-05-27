package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Tie;
import com.example.demo.service.TieService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tie")
public class TieController {

    @Autowired
    private TieService tieService;

    /* 发帖 */
    @PostMapping("/publish")
    public ResultDTO doPublish(@RequestBody Tie tie){
        ResultDTO result = tieService.publish(tie);
        return result;
    }

    /* 删帖 */
    @DeleteMapping("/delete/{id}")
    public ResultDTO deDelete(@PathVariable("id") Integer id){
        ResultDTO result = tieService.delete(id);
        return result;
    }

    /* 改贴 */
    @PutMapping("/update/{id}")
    public ResultDTO doUpdate(@RequestBody Tie tie,
                              @PathVariable("id") Integer id){
        tie.setId(id);
        ResultDTO update = tieService.update(tie);
        return update;
    }

    /* 查询所有帖子 */
    @GetMapping("/selectAllTie/{page}/{size}")
    public PageInfo deSelectAllTie(@PathVariable("page") Integer page,
                                   @PathVariable("size") Integer size){
        PageInfo pageInfo = tieService.selectAllTie(page, size);
        return pageInfo;
    }

    /*  查询个人所有帖子 */
    @GetMapping("selectPersonTie/{publishUserId}/{page}/{size}")
    public PageInfo doSelectPersonTie(@PathVariable("publishUserId") Integer publishUserId,
                                      @PathVariable("page") Integer page,
                                      @PathVariable("size") Integer size){
        PageInfo pageInfo = tieService.selectPersonTie(publishUserId, page, size);
        return pageInfo;
    }

    /* 查询某一个帖子 */
    @GetMapping("selectOneTie/{id}")
    public ResultDTO doSelectOneTie(@PathVariable("id") Integer id){
        ResultDTO resultDTO = tieService.selectOneTie(id);
        return resultDTO;
    }

}
