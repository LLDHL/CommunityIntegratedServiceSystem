package com.example.demo;

import org.junit.Test;

import java.util.Date;

public class BaseTest {
    @Test
    public void t1(){
        System.out.println((new Date()).getTime());
    }
}
