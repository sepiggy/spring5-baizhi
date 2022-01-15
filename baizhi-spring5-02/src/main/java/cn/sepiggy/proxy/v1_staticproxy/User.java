package cn.sepiggy.proxy.v1_staticproxy;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String name;
    private String password;

}
