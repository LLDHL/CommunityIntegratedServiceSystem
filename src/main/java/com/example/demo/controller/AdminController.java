package com.example.demo.controller;

import com.example.demo.component.RegisterImageUtils;
import com.example.demo.dto.AuthstrCheckDTO;
import com.example.demo.dto.ResultDTO;
import com.example.demo.exception.CustomErrorCode;
import com.example.demo.model.User;
import com.example.demo.service.EmailService;
import com.example.demo.service.TieService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @Autowired
    private TieService tieService;

    @Value("${win_registerImageDir}")
    private String win_registerImageDir;

    @Value("${linux_registerImageDir}")
    private String linux_registerImageDir;

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

    /* 管理员删帖的接口 */
    @DeleteMapping("/admin/deleteTie/{tieId}")
    public ResultDTO adminDoDeleteTie(@PathVariable("tieId") Integer tieId){
        ResultDTO delete = tieService.delete(tieId);
        return delete;
    }

    @Autowired
    private RegisterImageUtils registerImageUtils;
    @GetMapping("/admin/getRegisterImage")
    public ResultDTO<String> getRegisterImage(@RequestParam(name = "imageName") String imageName, HttpServletRequest req, HttpServletResponse res){
        String dir = registerImageUtils.getRegisterImageDir();
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + imageName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
//            String fileName = null;
//            String userAgent = req.getHeader("User-Agent");
//            try {
//                if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
//                    fileName = java.net.URLEncoder.encode(imageName, "UTF-8");
//                } else {
//                    fileName = new String(imageName.getBytes("UTF-8"), "ISO-8859-1");
//                }
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
            bis = new BufferedInputStream(new FileInputStream(new File(dir + imageName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResultDTO.errorOf(CustomErrorCode.FILE_NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultDTO.errorOf(CustomErrorCode.UNKNOWN_ERROR);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
        return ResultDTO.okOf("下载成功");
    }
}