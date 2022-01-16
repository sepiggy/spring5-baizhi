package cn.sepiggy.advice;

import cn.hutool.core.util.StrUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// MethodInterceptor 使用场景之检测性能（方法执行时间）
public class CheckPerformanceAroundAdvice implements MethodInterceptor {

    /*
         invoke方法的作用: 额外功能书写在 invoke 方法体内
                          额外功能  原始方法之前
                                   原始方法之后
                                   原始方法执行之前 之后
         如何拿到原始方法的引用？

         参数MethodInvocation: （类似于MethodBeforeAdvice#before中的Method参数): 代表额外功能所增加给的那个原始方法
                    login
                    register

          MethodInvocation#proceed ---> 代表原始方法运行
                                        eg. login运行, register运行

          返回值Object: 原始方法的返回值
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long now = System.currentTimeMillis();
        Object ret = invocation.proceed();
        long now1 = System.currentTimeMillis();
        String methodName = invocation.getMethod().getName();
        System.out.println(StrUtil.format("{}方法运行耗时: {}", methodName, (now1 - now)));
        return ret;
    }

}
