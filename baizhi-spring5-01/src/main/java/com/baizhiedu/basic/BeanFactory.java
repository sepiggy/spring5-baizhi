package com.baizhiedu.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

    private static Properties env = new Properties();

    static {
        try {
            // 第一步 获得IO输入流
            InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
            // 第二步 文件内容 封装 Properties集合中 key = userService value = com.baizhixx.UserServiceImpl
            env.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
       ! 对象的创建方式：
       ! 1. 直接调用构造方法创建对象:  UserService userService = new UserServiceImpl();
       ! 2. 通过反射的形式创建对象(解耦合):
       ! Class clazz = Class.forName("com.baizhiedu.basic.UserServiceImpl");
       ! UserService userService = (UserService)clazz.newInstance();
    */

    /**
     * 使用简单工厂创建特定对象：UserService, UserDAO
     * ? 问题：大量冗余代码
     */
    public static UserService getUserService() {
        UserService userService = null;
        try {
            // com.baizhiedu.basic.UserServiceImpl
            Class clazz = Class.forName(env.getProperty("userService"));
            userService = (UserService) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return userService;
    }

    public static UserDAO getUserDAO() {
        UserDAO userDAO = null;
        try {
            Class clazz = Class.forName(env.getProperty("userDAO"));
            userDAO = (UserDAO) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return userDAO;
    }

    /**
     * 使用通用工厂创建对象 (模拟 Spring IOC 工厂)
     * @param key 配置文件中的 key --> userDao, userService
     * @return
     */
    public static Object getBean(String key) {
        Object ret = null;
        try {
            Class clazz = Class.forName(env.getProperty(key));
            ret = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
