package cn.sepiggy.proxy.dynamicproxy_cglib;

import lombok.val;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/* 通过 cglib 方式创建动态代理对象 */
public class Main {

    public static void main(String[] args) {

        // 1. 原始对象
        val userService = new UserService();

        // 2. 额外功能
        val enhancer = new Enhancer();
        enhancer.setClassLoader(Main.class.getClassLoader());
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("cglib proxy...");
            Object ret = method.invoke(userService, objects);
            return ret;
        });

        val userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("sepiggy", "12345");
        userServiceProxy.register(new User());
    }
}
