package com.wiremock.wiremock.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionBeanScope {
    String msg;
   public SessionBeanScope(){
        System.out.println("SessionBeanScope() Bean scope"+ LocalDateTime.now());
       msg="This is a session bean scope "+ LocalDateTime.now();
    }

    public String msg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
