package com.example.belajar_spring_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("target(com.example.belajar_spring_aop)")
    public void helloServiceMethod() {

    }
    
}
