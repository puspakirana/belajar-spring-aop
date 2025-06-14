package com.example.belajar_spring_aop;

import com.example.belajar_spring_aop.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTests {

    @Autowired
    private HelloService helloService;

    @Test
    void helloService() {
        Assertions.assertEquals("Hello Eva", helloService.hello("Eva"));
        Assertions.assertEquals("Bye Eva", helloService.bye("Eva"));
        Assertions.assertEquals("Hello! You are requesting for number: 1", helloService.helloInt(1));
        Assertions.assertEquals("Call Hello Service", helloService.test());
    }
}