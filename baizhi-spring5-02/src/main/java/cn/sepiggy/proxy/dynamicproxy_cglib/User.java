package cn.sepiggy.proxy.dynamicproxy_cglib;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String name;
    private String password;

}
