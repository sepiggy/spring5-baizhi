package com.baizhiedu.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.baizhiedu.aop")
// 切换底层使用JDK代理还是Cglib代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
