package com.example.demo.controller;

import com.example.demo.Mapper.TieMapper;
import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Tie;
import com.example.demo.service.TieService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tie")
public class TieController {

    @Autowired
    private TieService tieService;

    @Autowired
    private TieMapper tieMapper;

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
    @GetMapping("selectOneTie/{id}")
    public ResultDTO doSelectOneTie(@PathVariable("id") Integer id){
        ResultDTO resultDTO = tieService.selectOneTie(id);
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

}
