package com.baizhiedu.factorybean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

@Data
@NoArgsConstructor
public class ConnectionFactoryBean implements FactoryBean<Connection> {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    // 用于书写创建复杂对象的具体实现
    @Override
    public Connection getObject() throws Exception {
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
