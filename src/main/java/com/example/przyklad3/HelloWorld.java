package com.example.przyklad3;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
