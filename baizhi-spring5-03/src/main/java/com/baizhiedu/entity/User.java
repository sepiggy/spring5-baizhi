package com.baizhiedu.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;
}
