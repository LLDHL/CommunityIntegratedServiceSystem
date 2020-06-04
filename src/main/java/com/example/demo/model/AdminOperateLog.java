package com.example.demo.model;

import lombok.Data;

@Data
public class AdminOperateLog {
    private Integer operateId;
    private Integer adminId;
    private String  requestMapping;
    private Long    date;
    private String operateIp;
    private String requestParameter;
    private String returnParameter;
}
