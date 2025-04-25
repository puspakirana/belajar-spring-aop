package com.example.belajar_spring_aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloService {
    
    public String hello(String name){
        return "Hello " + name;
    }

    public String bye(String name){
        return "Bye " + name;
    }

    public String helloInt(int number) {
        return "Hello! You are requesting for number: " + number;
    }

    public String test() {
        return "Call Hello Service";
    }

}
