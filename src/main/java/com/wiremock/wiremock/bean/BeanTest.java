package com.wiremock.wiremock.bean;

import org.springframework.stereotype.Component;

@Component
public class BeanTest {

    public  BeanTest(){
        System.out.println("Bean test: "+BeanTest.class);
    }
}
