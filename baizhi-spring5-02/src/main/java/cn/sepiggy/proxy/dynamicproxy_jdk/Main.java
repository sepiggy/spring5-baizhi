package cn.sepiggy.proxy.dynamicproxy_jdk;

import lombok.val;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 创建动态代理
 */
public class Main {

    public static void main(String[] args) {
        // 1. 原始对象
        val userService = new UserServiceImpl();

        // 2. 额外功能
        // 3. 相同接口
        val invocationHandler = new InvocationHandler() {
            // proxy: 代理对象
            // method: 原始方法
            // args: 原始方法参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("InvocationHandler#invoke before");
                // 原始方法运行
                val ret = method.invoke(userService, args);
                System.out.println("InvocationHandler#invoke after");
                return ret;
            }
        };

        // 代理对象
        // 借用 Main 对象的类加载器
        val userServiceProxy = (UserService) Proxy.newProxyInstance(Main.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                invocationHandler);

        userServiceProxy.login("sepiggy", "12345");
        userServiceProxy.register(new User());
    }

}
