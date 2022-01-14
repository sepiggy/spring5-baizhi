package cn.sepiggy.converter;


import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class MyDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        return null;
    }
}

