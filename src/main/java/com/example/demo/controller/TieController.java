package com.example.demo.controller;

import com.example.demo.dao.TieMapper;
import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Tie;
import com.example.demo.service.TieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/delete/{tieId}")
    public ResultDTO deDelete(@PathVariable("tieId") Integer tieId){
        ResultDTO result = tieService.delete(tieId);
        return result;
    }

    /* 改贴 */
    @PutMapping("/update/{tieId}")
    public ResultDTO doUpdate(@RequestBody Tie tie,
                              @PathVariable("tieId") Integer tieId){
        tie.setTieId(tieId);
        ResultDTO update = tieService.update(tie);
        return update;
    }

    /* 查询所有帖子 */
    @GetMapping("/selectAllTie/{page}/{size}")
    public ResultDTO deSelectAllTie(@PathVariable("page") Integer page,
                                    @PathVariable("size") Integer size){
        ResultDTO resultDTO = tieService.selectAllTie(page, size);
        return resultDTO;
    }

    /*  查询个人所有帖子 */
    @GetMapping("selectPersonTie/{userId}/{page}/{size}")
    public ResultDTO doSelectPersonTie(@PathVariable("userId") Integer userId,
                                      @PathVariable("page") Integer page,
                                      @PathVariable("size") Integer size){
        ResultDTO resultDTO = tieService.selectPersonTie(userId, page, size);
        return resultDTO;
    }

    /* 查询某一个帖子 */
    @GetMapping("selectOneTie/{tieId}")
    public ResultDTO doSelectOneTie(@PathVariable("tieId") Integer tieId){
        ResultDTO resultDTO = tieService.selectOneTie(tieId);
        return resultDTO;
    }

    /*  查询小区所有帖子 */
    @GetMapping("selectCommunityTie/{communityId}/{page}/{size}")
    public ResultDTO doSelectCommunityTie(@PathVariable("communityId") Integer communityId,
                                       @PathVariable("page") Integer page,
                                       @PathVariable("size") Integer size){
        ResultDTO resultDTO = tieService.selectCommunityTie(communityId, page, size);
        return resultDTO;
    }

    /* 点赞帖子 */
    @PutMapping("likeTie/{tieId}")
    public ResultDTO doLikeTie(@PathVariable("tieId") Integer tieId){
        ResultDTO resultDTO = tieService.likeTie(tieId);
        return resultDTO;
    }

    /* 取消点赞帖子 */
    @PutMapping("NotLikeTie/{tieId}")
    public ResultDTO doNotLikeTie(@PathVariable("tieId") Integer tieId){
        ResultDTO resultDTO = tieService.NotLikeTie(tieId);
        return resultDTO;
    }
}
