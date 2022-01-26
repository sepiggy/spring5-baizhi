package com.baizhiedu.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@NoArgsConstructor
public class Customer implements Serializable {
    private Integer id;
    private String name;
}
