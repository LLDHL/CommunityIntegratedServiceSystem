package com.example.demo.model;

import lombok.Data;

@Data
public class RespondComplaint {

    private Integer complaintId;
    private Integer respondComplaintUserId;
    private String respondComplaintUsername;
    private String respondComplaintContent;
    private String respondComplaintTime;
    private String respondComplaintAuthority;
    private String complaintStatus;

}
