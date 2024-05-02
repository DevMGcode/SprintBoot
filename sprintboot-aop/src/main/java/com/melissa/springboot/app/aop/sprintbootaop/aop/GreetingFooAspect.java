package com.melissa.springboot.app.aop.sprintbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Before("execution(String com.melissa.springboot.app.aop.sprintbootaop.services.GreetingService.*(..))")
  public void loggerBefore(JoinPoint joinPoint){
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("Antes Primero:" + method + " invocado con los parametros " + args); 
  }

    @After("execution(String com.melissa.springboot.app.aop.sprintbootaop.services.GreetingService.*(..))")
  public void loggerAfter(JoinPoint joinPoint){
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("Despues Primero:" + method + " invocado con los parametros " + args); 
  }

}