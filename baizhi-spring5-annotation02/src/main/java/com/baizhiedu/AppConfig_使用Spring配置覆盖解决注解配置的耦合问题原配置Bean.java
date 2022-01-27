package com.baizhiedu;

import com.baizhiedu.injection.UserDAO;
import com.baizhiedu.injection.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig_使用Spring配置覆盖解决注解配置的耦合问题原配置Bean {

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }
}
