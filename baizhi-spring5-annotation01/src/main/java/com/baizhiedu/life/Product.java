package com.baizhiedu.life;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Product {

    // 初始化方法
    @PostConstruct
    public void myInit() {
        System.out.println("Product.myInit");
    }

    // 销毁方法
    @PreDestroy
    public void myDestory() {
        System.out.println("Product.myDestory");
    }
}
