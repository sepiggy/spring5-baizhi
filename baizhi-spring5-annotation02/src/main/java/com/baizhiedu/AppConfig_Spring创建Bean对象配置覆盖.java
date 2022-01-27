package com.baizhiedu;

import com.baizhiedu.bean.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// 使用@ImportResource注解可以将配置文件的内容整合至配置Bean
@Configuration
@ComponentScan(basePackages = "com.baizhiedu.bean")
@ImportResource("applicationContext配置覆盖.xml")
public class AppConfig_Spring创建Bean对象配置覆盖 {

    // 使用@Bean创建对象的形式覆盖使用@Component创建对象的形式
    // 注意id值需要保持一致
    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("jms");
        return customer;
    }
}
