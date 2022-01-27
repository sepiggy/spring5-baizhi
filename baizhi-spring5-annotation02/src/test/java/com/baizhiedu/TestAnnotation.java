package com.baizhiedu;

import com.baizhiedu.bean.Customer;
import com.baizhiedu.bean.User;
import com.baizhiedu.four.Account;
import com.baizhiedu.four.AppConfig10;
import com.baizhiedu.injection.UserDAO;
import com.baizhiedu.injection.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

public class TestAnnotation {

    /**
     * 用于测试配置 Bean
     * 对于配置 Bean，使用新的工厂实现类 AnnotationConfigApplicationContext 代替 XML 配置文件中的 ClassPathXmlApplicationContext
     */
    @Test
    public void test1() {
        // 1) 指定配置 Bean 的 class
        // ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig0.class);
        // 2) 指定配置 Bean 所在的包
        ApplicationContext ctx = new AnnotationConfigApplicationContext("cn.sepiggy");
    }

    /**
     * 用于测试@Bean注解
     * @Bean 只能在配置 Bean (被 @Configuration 修饰的类) 中使用，用来修饰配置 Bean 中的方法
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过Bean注解创建对象.class);
//        User user = (User) ctx.getBean("user");
        User user = (User) ctx.getBean("u");
        System.out.println("user = " + user);

        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);

        Connection conn1 = (Connection) ctx.getBean("conn1");
        System.out.println("conn1 = " + conn1);
    }


    /**
     * 用于测试对象的创建次数
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过Bean注解创建对象.class);
        User u = (User) ctx.getBean("u");
        User u1 = (User) ctx.getBean("u");
        System.out.println("u = " + u);
        System.out.println("u1 = " + u1);
    }

    /**
     * 用于测试@Bean注入用户自定义类型
     */
    @Test
    public void test4() {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过Bean注解注入用户自定义类型.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过Bean注解注入用户自定义类型简化写法.class);
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register();
    }

    /**
     * 用于测试@Bean注入JDK类型
     */
    @Test
    public void test5() {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过Bean注解注入JDK类型.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过Bean注解注入JDK类型解耦合版.class);
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer.getId());
        System.out.println("customer = " + customer.getName());
    }

    /**
     * 用于测试@ComponentScan和@Import基本使用
     */
    @Test
    public void test6() {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过ComponentScan注解配置扫描范围.class);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过ComponentScan注解配置排除策略.class);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过ComponentScan注解配置包含策略.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过Import注解创建Bean对象.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * 用于测试配置的覆盖
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_Spring创建Bean对象配置覆盖.class);
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer.getId() = " + customer.getId());
        System.out.println("customer.getName() = " + customer.getName());
    }

    /**
     * 用于测试注解配置解耦合
     */
    @Test
    public void test8() {
        // AnnotationConfigApplicationContext 可以接收多个配置Bean参数
        // 这里使用多个配置文件的好处是保持"开闭原则"
        // 原来的配置Bean不必做修改
        // 只需要增加一个新的配置Bean, 而这个新的配置Bean的作用就是读取配置文件中新的UserDAO的实现类
        // 从而可以覆盖使用@Component注解创建的原有的UserDAO的实现类
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                AppConfig_使用Spring配置覆盖解决注解配置的耦合问题原配置Bean.class,
                AppConfig_使用Spring配置覆盖解决注解配置的耦合问题新增配置Bean.class
        );

        // 也可以指定Spring工厂在特定package内搜索配置Bean
        // ApplicationContext ctx = new AnnotationConfigApplicationContext("com.baizhiedu");

        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        userDAO.save();
    }

    /**
     * 用于测试:多配置Bean的整合
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.baizhiedu.config");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);

    }


    @Test
    public void test10() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.baizhiedu.config.AppConfig1.class);
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        UserService userService = (UserService) ctx.getBean("userService");
        /*System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);

        */

        userService.register();
    }


    /**
     * 用于测试:@Component与配置Bean的整合
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.baizhiedu.config.AppConfig3.class);
        UserService userService = (UserService) ctx.getBean("userService");
        /*UserDAO userDAOImpl = (UserDAO) ctx.getBean("userDAOImpl");
        System.out.println("userService = " + userService);
        System.out.println("userDAOImpl = " + userDAOImpl);
*/
        userService.register();
    }


    @Test
    public void test12() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.baizhiedu.config.AppConfig4.class);
        UserService userService = (UserService) ctx.getBean("userService");
        /*UserDAO userDAOImpl = (UserDAO) ctx.getBean("userDAO");
        System.out.println("userService = " + userService);
        System.out.println("userDAOImpl = " + userDAOImpl);*/

        userService.register();

    }

    @Test
    public void test13() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig_通过Bean注解创建对象.class);
        User u = (User) ctx.getBean("u");

    }

    /**
     * 用于测试:四维一体开发
     */
    @Test
    public void test14() {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig10.class);
        Account account = (Account) ctx.getBean("account");
        System.out.println("account.getId() = " + account.getId());
        System.out.println("account.getName() = " + account.getName());

    }


}




































