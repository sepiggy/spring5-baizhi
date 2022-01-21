package com.baizhiedu;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.entity.User;
import com.baizhiedu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestMybatisSpring {

    /**
     * 用于测试:Spring与Mybatis的整合
     * Spring与Mybatis整合开发的步骤：
     * 1. 实体
     * 2. 表
     * 3. 创建DAO接⼝
     * 4. 实现Mapper⽂件
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        System.out.println("beanDefinitionNames = " + Arrays.toString(beanDefinitionNames));

        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

        User user = new User();
        user.setName("xiaojr");
        user.setPassword("999999");

        userDAO.save(user);
    }

    /**
     * 用于测试Spring的事务处理
     * 连接对象控制了事物，谁控制了连接对象也就变相控制了事物
     */
    @Test
    public void test2() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 这里通过 "userService" 这个 id 其实获取到的是 UserService 的代理对象
        UserService userService = (UserService) ctx.getBean("userService");
        User user = new User();
        user.setName("xiaowb2");
        user.setPassword("989898");
        userService.register(user);
    }

    /**
     * 用于测试:Spring基于标签事务处理
     */
    @Test
    public void test3() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext-tx.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User();
        user.setName("xiaowb4");
        user.setPassword("989898");
        userService.register(user);

    }

}
