package com.example.demo.service;

import com.example.demo.Mapper.TieMapper;
import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Tie;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TieService {

    @Autowired
    private TieMapper tieMapper;

    /* 发帖操作 */
    public ResultDTO publish(Tie tie){
        /*获取当前时间*/
        Date date = new Date();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        tie.setPublishTime(nowTime);
        tieMapper.publish(tie);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("获取成功",tie);
    }

    /*删帖操作*/
    public ResultDTO delete(Integer id){
        tieMapper.deleteTie(id);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf();
    }

    /* 修改操作 */
    public ResultDTO update(Tie tie) {
        tieMapper.updateTie(tie);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("修改成功",tie);
    }

    /* 查询全部帖子操作 */
    public ResultDTO selectAllTie(Integer page, Integer size){
        PageHelper.offsetPage(page-1,size);
        List<Tie> ties = tieMapper.selectAllTie();
        PageInfo pageInfo = new PageInfo(ties);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("查询成功",pageInfo);
    }

    /* 查询个人的所有帖子 */
    public ResultDTO selectPersonTie(Integer userId, Integer page, Integer size) {
        PageHelper.offsetPage(page-1,size);
        List<Tie> ties = tieMapper.selectPersonTie(userId);
        PageInfo pageInfo = new PageInfo(ties);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("查询成功",pageInfo);
    }

    /* 查询一个帖子 */
    public ResultDTO selectOneTie(Integer id) {
        Tie tie = tieMapper.selectOneTie(id);
        int sum = tie.getBrowse()+1;
        tieMapper.rememberBrowse(sum,id);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("查询成功",tie);
    }

    /*查询小区的帖子*/
    public ResultDTO selectCommunityTie(Integer communityId, Integer page, Integer size) {
        PageHelper.offsetPage(page-1,size);
        List<Tie> ties = tieMapper.selectCommunityTie(communityId);
        PageInfo pageInfo = new PageInfo(ties);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("获取成功",pageInfo);

    }
}
