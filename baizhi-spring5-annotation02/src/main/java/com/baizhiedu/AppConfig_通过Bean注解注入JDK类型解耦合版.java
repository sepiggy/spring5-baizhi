package com.baizhiedu;

import com.baizhiedu.bean.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 通过Bean注解注入JDK类型改进版:
 * 通过@Value+properties配置文件解耦合:
 * 1) 准备properties配置文件
 * 2) 将配置文件读入程序
 * 3) 通过@Value注解注入程序
 */
@Configuration
@PropertySource("classpath:/init.properties")
public class AppConfig_通过Bean注解注入JDK类型解耦合版 {

    @Value("${id}")
    private Integer id;
    @Value("${name}")
    private String name;

    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        return customer;
    }
}
