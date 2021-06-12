package com.example.przyklad4;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HelloWorld {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean is initializing");
    }

    @PreDestroy
    public void destory() {
        System.out.println("Bean will be destroyed now");
    }
}
