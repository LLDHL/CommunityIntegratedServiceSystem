package com.example.demo;

import org.apache.tomcat.jni.Time;
import org.junit.Test;

import java.util.Date;
import java.util.Timer;

public class BaseTest {
    @Test
    public void t1(){
        System.out.println((new Date()).getTime());
        System.out.println(System.currentTimeMillis());
    }
}
