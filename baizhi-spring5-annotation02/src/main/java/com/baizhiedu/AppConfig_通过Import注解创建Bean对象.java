package com.baizhiedu;

import com.baizhiedu.bean.People;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(People.class)
public class AppConfig_通过Import注解创建Bean对象 {

}
