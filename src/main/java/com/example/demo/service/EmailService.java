package com.example.demo.service;

import com.example.demo.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSenderImpl mailSender;

    public ResultDTO sendEmail(String setToEmail,String emailTitle, String emailContent){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(emailTitle);
        message.setText(emailContent);
        message.setTo(setToEmail);
        message.setFrom("594183034@qq.com");
        mailSender.send(message);
        ResultDTO resultDTO = new ResultDTO();
        return resultDTO.okOf("发送成功",message);
    }

}
