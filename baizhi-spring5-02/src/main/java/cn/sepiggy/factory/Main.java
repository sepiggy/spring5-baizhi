package cn.sepiggy.factory;

import com.baizhiedu.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/sepiggy/factory.xml");

        // 通过原始对象的 id，获取到的是代理对象
        UserService userService = (UserService) ctx.getBean("userService");

        userService.login("sepiggy", "12345");
        userService.register(new User());
    }

}
