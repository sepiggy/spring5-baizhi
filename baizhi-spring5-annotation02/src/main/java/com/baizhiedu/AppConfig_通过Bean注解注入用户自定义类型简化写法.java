package com.baizhiedu;

import com.baizhiedu.injection.UserDAO;
import com.baizhiedu.injection.UserDAOImpl;
import com.baizhiedu.injection.UserService;
import com.baizhiedu.injection.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig_通过Bean注解注入用户自定义类型简化写法 {

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

    // @Bean注解用户自定义类型注入步骤简化写法:
    // 1. 不需要显示声明形式参数，直接调用 setter 进行赋值
    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO()); // 通过 userDao() 返回值进行注入
        return userService;
    }
}
