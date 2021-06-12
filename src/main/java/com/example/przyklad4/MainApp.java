package com.example.przyklad4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("przyklad4/Beans.xml");
        //HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        //helloWorld.setMessage("test");
        //System.out.println(helloWorld.getMessage());
        context.registerShutdownHook();
    }
}
