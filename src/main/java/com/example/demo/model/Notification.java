package com.example.demo.model;

import lombok.Data;

@Data
public class Notification {
    private Integer noticeId;
    private Integer notifierId;
    private Integer receiverId;
    private Integer type;
    private Long Gmt_create;
    private Integer status;
    private String data;
}
