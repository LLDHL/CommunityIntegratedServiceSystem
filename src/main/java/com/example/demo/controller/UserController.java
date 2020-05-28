package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.User;
import com.example.demo.untils.RandomValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @RequestMapping(value = "/validateCodeImg", method = RequestMethod.GET)
    public ResultDTO<String> downloadWCImage(HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);// 输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
//   https://blog.csdn.net/u010648555/article/details/52261050em.out.println("success");
        return ResultDTO.okOf("验证码获取成功");
    }

    @PostMapping("/register")
    public ResultDTO<String> userRegister(@RequestBody User user){
        return ResultDTO.okOf("注册申请已提交");
    }



}
