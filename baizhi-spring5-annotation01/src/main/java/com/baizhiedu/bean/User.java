package com.baizhiedu.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

//@Component
@Component("u")
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
}
