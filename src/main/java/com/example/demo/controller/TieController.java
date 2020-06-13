package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Tie;
import com.example.demo.service.NotificationService;
import com.example.demo.service.TieService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TieController {

    @Autowired
    private TieService tieService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;


    /* 发帖 */
    @PostMapping("/ties")
    public ResultDTO doPublish(@RequestBody Tie tie){

        ResultDTO result = tieService.publish(tie);
        return result;
    }

    /* 删帖 */
    @DeleteMapping("/ties/{tieId}")
    public ResultDTO deDelete(@PathVariable("tieId") Integer tieId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        if (tieService.findTieByTieId(tieId,userId)){
            ResultDTO result = tieService.delete(tieId);
            return result;
        }else{
            return ResultDTO.errorOf(401,"你无权这么做");
        }
    }

    /* 改贴 */
    @PutMapping("/ties/{tieId}")
    public ResultDTO doUpdate(@RequestBody Tie tie,
                              @PathVariable("tieId") Integer tieId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        if (tieService.findTieByTieId(tieId,userId)){
            tie.setTieId(tieId);
            ResultDTO update = tieService.update(tie);
            return update;
        }else{
            return ResultDTO.errorOf(401,"你无权这么做");
        }
    }

    /* 查询所有帖子 */
    @GetMapping("/ties")
    public ResultDTO deSelectAllTie2(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                     @RequestParam(name = "size", defaultValue = "5") Integer size){
        ResultDTO resultDTO = tieService.selectAllTie(page-1, size);
        return resultDTO;
    }

    /*  查看个人所有帖子 */
    @GetMapping("/users/ties/{userId}")
    public ResultDTO doSelectPersonTie(@PathVariable("userId") Integer userId,
                                       @RequestParam(name = "page", defaultValue = "1") Integer page,
                                       @RequestParam(name = "size",defaultValue = "5") Integer size){
        ResultDTO resultDTO = tieService.selectPersonTie(userId, page-1, size);
        return resultDTO;
    }

    /* 查询某一个帖子 */
    @GetMapping("/ties/{tieId}")
    public ResultDTO doSelectOneTie(@PathVariable("tieId") Integer tieId){
        ResultDTO resultDTO = tieService.selectOneTie(tieId);
        return resultDTO;
    }

    /*  查询小区所有帖子 */
    @GetMapping("/community/ties")
    public ResultDTO doSelectCommunityTie(@RequestParam(name = "communityId") Integer communityId,
                                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                                          @RequestParam(name = "size",defaultValue = "5") Integer size){
        ResultDTO resultDTO = tieService.selectCommunityTie(communityId, page-1, size);
        return resultDTO;
    }

    /* 点赞帖子 */
    @PutMapping("/ties/like/{tieId}")
    public ResultDTO doLikeTie(@PathVariable("tieId") Integer tieId){
        ResultDTO resultDTO = tieService.likeTie(tieId);
        return resultDTO;
    }

    /* 取消点赞帖子 */
    @PutMapping("/ties/notLike/{tieId}")
    public ResultDTO doNotLikeTie(@PathVariable("tieId") Integer tieId){
        ResultDTO resultDTO = tieService.NotLikeTie(tieId);
        return resultDTO;
    }
}
