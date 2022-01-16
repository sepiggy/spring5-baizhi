package cn.sepiggy.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdvice implements MethodBeforeAdvice {

    /*
      作用：需要把运行在原始方法执行之前运行的额外功能，书写在 before 方法中

      Method: 额外功能所增加给的那个原始方法

              eg. login方法

              register方法

              showOrder方法

      Object[]: 额外功能所增加给的那个原始方法的参数。String name, String password
                                                User

       Object: 额外功能所增加给的那个原始对象  UserServiceImpl
                                          OrderServiceImpl
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice.before");
    }

}
