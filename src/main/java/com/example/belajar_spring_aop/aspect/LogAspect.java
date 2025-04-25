package com.example.belajar_spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {

    public LogAspect() {
        log.info("LogAspect initialized");
    }

    @Pointcut("target(com.example.belajar_spring_aop.service.HelloService)")
    public void helloServiceMethod() {
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Before " + className + "." + methodName + "()");
    }

    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Before " + className + "." + methodName + "()");
        try {
            log.info("Around before " + className + "." + methodName + "()");
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.info("Around throwable " + className + "." + methodName + "()");
            throw throwable;
        } finally {
            log.info("Around finally " + className + "." + methodName + "()");
        }
    }

    @Pointcut("execution(* com.example.belajar_spring_aop.service.HelloService.*(java.lang.String))")
    public void pointcutHelloServiceStringParam(){}

    @Before("pointcutHelloServiceStringParam()")
    public void logStringParameter(JoinPoint joinPoint) {
        String value = (String) joinPoint.getArgs()[0];
        log.info("Execute method with parameter: " + value);
    }

    @Pointcut("execution(* com.example.belajar_spring_aop.service.*.*(..))")
    public void pointcutServicePackage() {}

    @Pointcut("bean(*Service)")
    public void pointcutServiceBean() {}

    @Pointcut("execution(public * *(..))")
    public void pointcutPublicMethod() {}

    @Pointcut("pointcutServicePackage() && pointcutServiceBean() && pointcutPublicMethod()")
    public void publicMethodForService() {}

    @Before("publicMethodForService()")
    public void logAllPublicServiceMethod() {
        log.info("Log for all public service method");
    }
    
}
