package cn.sepiggy.test;

import cn.sepiggy.beanpost.Book;
import cn.sepiggy.beanpost.Category;
import lombok.val;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用于测试后置处理器
 */
public class Main3 {

    public static void main(String[] args) {
        val ctx = new ClassPathXmlApplicationContext("/spring-sepiggy.xml");
        val category = ctx.getBean("c", Category.class);
        // category = Category(id=10, name=jms)
        System.out.println("category = " + category);

        val book = ctx.getBean("b", Book.class);
        System.out.println("book = " + book);
    }
}
