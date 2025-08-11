package com.wiremock.wiremock.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Singletonbean {
    @Autowired
    PrototypeBean prototypeBean;
    public Singletonbean() {
        System.out.println("Singleton bean Initialization.."+Singletonbean.class);
    }

    public PrototypeBean prototypeBean(){
        return prototypeBean(); }
}
