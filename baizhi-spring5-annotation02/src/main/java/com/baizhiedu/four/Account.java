package com.baizhiedu.four;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
//@PropertySource("classpath:four.properties")
@Data
public class Account implements Serializable {

    @Value("${id}")
    private Integer id;

    @Value("${name}")
    private String name;
}
