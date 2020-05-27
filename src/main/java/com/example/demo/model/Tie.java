package com.example.demo.model;

import lombok.Data;

@Data
public class Tie {

    /*帖子表*/
    private Integer id;   // 帖子id
    private Integer publishUserId;  // 发帖人 id
    private String publishUsername;  //发帖人姓名
    private String publishUserCommunity;  //发帖人小区
    private String title;  //标题
    private String content;  //内容
    private String label;  //标签
    private String publishTime;  //发表时间
    private String pictureAddress;  //图片地址
    private Integer browse;  //浏览次数
    private Integer tieTypes;  //帖子类型
    private Integer likes;  //点赞次数



}
