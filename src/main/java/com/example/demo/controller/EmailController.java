package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Email;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/deSendEmail")
    public ResultDTO deSendEmail(@RequestBody Email email){
        ResultDTO resultDTO = emailService.sendEmail(email.getSetToEmail(), email.getEmailTitle(), email.getEmailContent());
        return resultDTO;
    }

}
