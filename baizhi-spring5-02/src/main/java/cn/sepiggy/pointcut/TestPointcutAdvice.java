package cn.sepiggy.pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TestPointcutAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before...");
        Object result = invocation.proceed();
        System.out.println("after...");
        return result;
    }

}
