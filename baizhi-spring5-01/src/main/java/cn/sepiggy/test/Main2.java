package cn.sepiggy.test;

import cn.sepiggy.entity.Person1;
import lombok.val;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用于测试自定义类型转换器
 */
public class Main2 {

    public static void main(String[] args) {
        val ctx = new ClassPathXmlApplicationContext("/spring-sepiggy.xml");
        val person1 = ctx.getBean("person1", Person1.class);
        System.out.println("person1 = " + person1);
    }
}
