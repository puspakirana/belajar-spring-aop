package com.example.belajar_spring_aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public class HelloService {
    
    public String hello(String name){
        log.info("Call HelloService.hello()");
        return "Hello " + name;
    }

    public String bye(String name){
        log.info("Call HelloService.bye()");
        return "Bye " + name;
    }

}
