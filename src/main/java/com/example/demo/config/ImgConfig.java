package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImgConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 暂时用不上，部署了再用
         registry.addResourceHandler("/static/picture/**")
                 .addResourceLocations("file:" + "C:\\Users\\Administrator\\Desktop\\head\\");
    }
}