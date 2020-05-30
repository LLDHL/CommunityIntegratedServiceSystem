package com.example.demo.controller;

import com.example.demo.dto.ResultDTO;
import com.example.demo.service.PictureService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @PostMapping("/upload")
    public ResultDTO uploadPicture(@RequestParam("file") MultipartFile file){
        ResultDTO resultDTO = pictureService.doUploadPicture(file);
        return resultDTO;
    }

}
