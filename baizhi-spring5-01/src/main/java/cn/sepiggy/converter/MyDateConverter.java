package cn.sepiggy.converter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@NoArgsConstructor
public class MyDateConverter implements Converter<String, Date> {

    private String pattern;

    @Override
    public Date convert(String source) {
        Date date = null;
        val sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

