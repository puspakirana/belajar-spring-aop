package com.example.belajar_spring_aop;

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
    }
}