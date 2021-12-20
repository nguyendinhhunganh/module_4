package com.example.ung_dung_muon_sach.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* com.example.ung_dung_muon_sach.service.BookService.*(..))")
    public void bookService() {};

    @After("bookService()")
    public void getLog(JoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: " + methodName);
    }
}
