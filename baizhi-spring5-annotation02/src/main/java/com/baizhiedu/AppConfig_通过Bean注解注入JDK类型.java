package com.baizhiedu;

import com.baizhiedu.bean.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig_通过Bean注解注入JDK类型 {

    // 通过setter手动对JDK类型的字段进行设置即可
    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("sepiggy");
        return customer;
    }
}
