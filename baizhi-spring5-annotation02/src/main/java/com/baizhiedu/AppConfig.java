package com.baizhiedu;

import com.baizhiedu.bean.ConnectionFactoryBean;
import com.baizhiedu.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 配置 Bean
 * 通过 @Configuration 注解标注一个类是配置 Bean，用于替代 XML 配置文件
 */
@Configuration
public class AppConfig {


    /**
     * 创建简单对象
     */
    @Bean("u")
    @Scope("prototype")
    public User user() {
        return new User();
    }

    /**
     * 创建复杂对象
     * Connection 不能直接通过 new 创建
     */
    @Bean
    public Connection conn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring5?useSSL=false", "root", "12345");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 整合通过 FactoryBean 接口创建复杂对象
     * 这种方式创建复杂对象，多用于遗留系统整合
     */
    @Bean
    public Connection conn1() {
        Connection conn = null;
        try {
            ConnectionFactoryBean factoryBean = new ConnectionFactoryBean();
            conn = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
