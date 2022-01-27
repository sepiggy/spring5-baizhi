package com.baizhiedu;

import com.baizhiedu.bean.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

// 与XML配置文件的形式配置包含策略是一致的
@Configuration
@ComponentScan(basePackages = "com.baizhiedu.scan",
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})})
public class AppConfig_通过ComponentScan注解配置包含策略 {

}
