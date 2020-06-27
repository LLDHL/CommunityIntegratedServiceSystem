package com.example.demo.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RegisterImageUtils {

    @Value("${win_registerImageDir}")
    private String win_registerImageDir;

    @Value("${linux_registerImageDir}")
    private String linux_registerImageDir;

    public String getRegisterImageDir(){
        String dir=null;
        if(isWindows()){
            dir=win_registerImageDir;
        }else {
            dir=linux_registerImageDir;
        }
        return dir;
    }

    public boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
}
