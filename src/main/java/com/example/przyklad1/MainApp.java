package com.example.przyklad1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "przyklad1/Beans.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("myBean");
        System.out.println(helloWorld.getMessage());
    }
}
