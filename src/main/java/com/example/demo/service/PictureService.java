package com.example.demo.service;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Picture;
import com.example.demo.untils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.UUID;

@Service
public class PictureService {


    public ResultDTO doUploadPicture(MultipartFile file) {

        if ((file.getOriginalFilename().isEmpty())){
            return ResultDTO.errorOf(500,"上传失败");
        }else{
            String fileName = file.getOriginalFilename();

            String hToken = UUID.randomUUID().toString();
            
            //防止图片名字重复
            String resultName = hToken + fileName ;
            // 地址改成服务器地址就ok了
            //String filePath = "C:\\Users\\Lzy\\Desktop\\img\\";
            String filePath = "C:\\Users\\Administrator\\Desktop\\img\\";
            // 图片的路径 = 文件夹地址 + 新名字
            String fileAddress = filePath + resultName;
            try{
                FileUtil.uploadFile(file.getBytes(),filePath,resultName);
            }catch (Exception e){
            }
            Picture picture = new Picture();
            picture.setPictureName(resultName);
            picture.setPictureAddress(fileAddress);
            return ResultDTO.okOf("上传成功",picture);
        }
    }
}
