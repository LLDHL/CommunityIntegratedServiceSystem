package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class BCryptPasswordEncoderTest {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Test
    public void buildPasswordTest(){
        String name = bCryptPasswordEncoder.encode("name");
        System.out.println();
    }

    @Test
    public void matchPasswordTest(){
        String encoded="$2a$10$hQgnUUxaNJdvymtzdZ2/QObGgWIZvFAmwGplN/OcSvnukGCox3lt2";
        boolean b = bCryptPasswordEncoder.matches("name", encoded);
        System.out.println(b);
    }
}
