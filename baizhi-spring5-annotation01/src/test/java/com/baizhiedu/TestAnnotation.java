package com.baizhiedu;

import com.baizhiedu.bean.User;
import com.baizhiedu.injection.Category;
import com.baizhiedu.injection.UserService;
import com.baizhiedu.lazy.Account;
import com.baizhiedu.scope.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

    /**
     * 用于测试@Component注解
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        User user = (User) ctx.getBean("user");
        User user = (User) ctx.getBean("u");
        System.out.println("user = " + user);
        System.out.println("user id = " + user.getId());
    }

    /**
     * 用于测试@Scope注解
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        Customer customer1 = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
        System.out.println("customer1 = " + customer1);
    }


    /**
     * 用于测试@Lazy注解
     * 对于单实例对象，使用@Lazy注解后，Spring会在使用这个对象的时候才创建，而不是Bean容器初始化好后就创建这个对象
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account = (Account) ctx.getBean("account");
    }


    /**
     * 用于测试生命周期相关的注解: @PostContruct、 @PreDestroy
     */
    @Test
    public void test4() {
        // 调用初始化方法：被 @PostContruct 修饰的方法
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 调用销毁方法：被 @PreDestroy 修饰的方法
        ctx.close();
    }

    /**
     * 用于测试@Autowired注解
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        userServiceImpl.register();
    }

    /**
     * 用于测试@Value注解
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Category category = (Category) ctx.getBean("category");
        System.out.println("category.getId() = " + category.getId());
        System.out.println("category.getName() = " + category.getName());
    }

    /**
     * 用于测试排除策略
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }
}
