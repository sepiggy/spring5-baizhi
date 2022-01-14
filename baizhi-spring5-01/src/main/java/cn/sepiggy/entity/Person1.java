package cn.sepiggy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Person1 implements Serializable {

    private String name;
    private Date birthday;
}
