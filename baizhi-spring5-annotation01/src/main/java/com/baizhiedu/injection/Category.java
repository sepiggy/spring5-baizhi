package com.baizhiedu.injection;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/init.properties")
@Data
public class Category {
    @Value("${id}")
//    private static Integer id;
    private Integer id;
    @Value("${name}")
    private String name;
}
