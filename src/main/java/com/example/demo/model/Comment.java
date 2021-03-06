package com.example.demo.model;

import lombok.Data;

@Data
public class Comment {

    public Integer commentId;
    public Integer tieId;
    public String commentUsername;
    public Integer commentUserId;
    public String commentContent;
    public String commentTime;
    public Integer commentLikes;
    public Integer commentTypes;
    public String commentPicture;

}
