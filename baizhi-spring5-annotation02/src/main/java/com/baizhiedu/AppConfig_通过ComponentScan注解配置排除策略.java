package com.baizhiedu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

/// 与XML配置文件的形式配置排除策略是一致的
@Configuration
@ComponentScan(basePackages = "com.baizhiedu.scan",
        excludeFilters = {
        // 基于注解排除
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class}),
        // 基于切入点表达式排除
                @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "*..User1")
})
public class AppConfig_通过ComponentScan注解配置排除策略 {

}
