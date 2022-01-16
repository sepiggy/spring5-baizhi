package cn.sepiggy.advice;

import lombok.val;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        val ctx = new ClassPathXmlApplicationContext("/sepiggy/advice.xml");
        val userService = ctx.getBean("userService", UserService.class);
        userService.login("jms", "12345");
        userService.register(new User());
    }

}
