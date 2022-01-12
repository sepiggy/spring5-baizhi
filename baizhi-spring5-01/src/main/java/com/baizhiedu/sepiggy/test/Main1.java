package com.baizhiedu.sepiggy.test;

import com.baizhiedu.sepiggy.entity.Person;
import com.baizhiedu.sepiggy.entity.Section;
import lombok.val;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

    public static void main(String[] args) {
        val classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-sepiggy.xml");

/*
        val section = classPathXmlApplicationContext.getBean("section", Section.class);
        System.out.println("section = " + section);

        // 既能判断id, 又能判断name
        val b1 = classPathXmlApplicationContext.containsBean("s2");
        System.out.println("b1 = " + b1);

        // 只能判断id, 不能判断name
        val b2 = classPathXmlApplicationContext.containsBeanDefinition("s2");
        System.out.println("b2 = " + b2);
*/

        val person = classPathXmlApplicationContext.getBean("person", Person.class);
        System.out.println("person = " + person);

    }

}
