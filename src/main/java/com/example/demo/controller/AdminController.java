package com.example.demo.controller;

import com.example.demo.dto.AuthstrCheckDTO;
import com.example.demo.dto.ResultDTO;
import com.example.demo.model.User;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/admin/checkAuthstr")
    public ResultDTO<String> checkAuthstr(@RequestBody AuthstrCheckDTO authstrCheckDTO){
        String authstrEmail = userService.getAuthstrEmail(authstrCheckDTO.getAuthstrId());
        userService.adminAuthstr(authstrCheckDTO.getAuthstrId(),
                authstrCheckDTO.getResult(),authstrCheckDTO.getMessage());
        emailService.sendEmail(authstrEmail,"审核结果",authstrCheckDTO.getMessage());
        return ResultDTO.okOf("处理完成");
    }

    @RequestMapping(value = "/admin/getAuthstrs",method = RequestMethod.GET)
    public ResultDTO<List<User>> getAuthstrs(){
        List<User> authstrs = userService.getAuthstrs();
        for (User u :authstrs) {//防止加密后密码泄密
            u.setPassword("");
        }
        return ResultDTO.okOf("待审核列表",authstrs);
    }
}
