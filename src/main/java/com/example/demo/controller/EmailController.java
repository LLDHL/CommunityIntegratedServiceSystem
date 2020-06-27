package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Email;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/email")
    public ResultDTO deSendEmail(@RequestBody Email email){
        ResultDTO resultDTO = emailService.sendEmail(email.getSetToEmail(), email.getEmailTitle(), email.getEmailContent());
        return resultDTO;
    }

}
