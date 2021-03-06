package com.example.demo.model;

import lombok.Data;

@Data
public class PublishComplaint {

    private Integer complaintId;
    private Integer userId;
    private String username;
    private String complaintContent;
    private Integer communityId;
    private String complaintTime;
    private String userEmail;
    private String userPhone;
    private String complaintStatus;

}
