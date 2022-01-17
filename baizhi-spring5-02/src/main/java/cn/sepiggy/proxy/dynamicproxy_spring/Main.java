package cn.sepiggy.proxy.dynamicproxy_spring;

import lombok.val;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        val ctx = new ClassPathXmlApplicationContext("/sepiggy/proxyv2.xml");

        // 注意：
        // 1. Spring 工厂通过原始对象的 id 值获得代理对象
        // 2. 获得代理对象后可以通过声明接口类型进行代理对象的引用

        val userService = ctx.getBean("userService", UserService.class);
        userService.login("jms", "12345");
        userService.register(new User());

        val orderService = ctx.getBean("orderService", OrderService.class);
        orderService.showOrder();
    }

}
