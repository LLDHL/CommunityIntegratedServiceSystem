package com.example.demo.untils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5 {

    public String doMd5Int(String key){
        String md5Hex = DigestUtils
                .md5Hex(key).toUpperCase();
        return md5Hex;
    }

}
