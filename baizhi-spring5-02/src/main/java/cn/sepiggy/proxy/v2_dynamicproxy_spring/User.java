package cn.sepiggy.proxy.v2_dynamicproxy_spring;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String name;
    private String password;

}
