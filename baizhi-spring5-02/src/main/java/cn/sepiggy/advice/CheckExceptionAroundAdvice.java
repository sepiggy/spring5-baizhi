package cn.sepiggy.advice;

import cn.hutool.core.util.StrUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// MethodInterceptor 使用场景之检测方法产生异常
public class CheckExceptionAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object ret = null;
        try {
            ret = invocation.proceed();
        } catch (Throwable e) {
            System.out.println(StrUtil.format("{}-{}-{}", e.getClass().getName(), e.getMessage(), e.getStackTrace()));
            e.printStackTrace();
        }
        return ret;
    }

}
