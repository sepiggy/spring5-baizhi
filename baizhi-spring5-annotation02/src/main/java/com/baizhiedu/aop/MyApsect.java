package com.baizhiedu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 创建切面类：
 * 1. 额外功能
 * 2. 切入点
 * 3. 组装切面
 */
@Aspect
@Component
public class MyApsect {

    @Pointcut("execution(* com.baizhiedu.aop..*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----Log-----");
        Object proceed = joinPoint.proceed();

        return proceed;
    }
}
