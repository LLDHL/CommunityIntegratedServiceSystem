package com.example.demo.model;

import lombok.Data;


public class Email {

    private String setToEmail;
    private String emailTitle;
    private String emailContent;

    public String getSetToEmail() {
        return setToEmail;
    }

    public void setSetToEmail(String setToEmail) {
        this.setToEmail = setToEmail;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }
}
