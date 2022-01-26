package com.baizhiedu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration注解 aka "<context:component-scan base-package=""/>"
 */
@Configuration
@ComponentScan(basePackages = "com.baizhiedu.scan")
public class AppConfig_通过ComponentScan注解配置扫描范围 {

}
