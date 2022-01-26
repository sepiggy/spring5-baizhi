package com.baizhiedu;

import com.baizhiedu.injection.UserDAO;
import com.baizhiedu.injection.UserDAOImpl;
import com.baizhiedu.injection.UserService;
import com.baizhiedu.injection.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig_通过Bean注解注入用户自定义类型 {

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

    // @Bean注解用户自定义类型注入步骤:
    // 1. 定义形式参数
    // 2. 调用 setter 进行赋值
    @Bean
    public UserService userService(UserDAO userDAO) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO);
        return userService;
    }
}
