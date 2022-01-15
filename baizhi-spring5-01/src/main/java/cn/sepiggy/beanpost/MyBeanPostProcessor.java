package cn.sepiggy.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        // BeanPostProcessor 会对 Spring 工厂中所有创建的对象进行加工，如果不用 instanceof 操作符做限定会报类型转换错误
        if (bean instanceof Category) {
            Category category = (Category) bean;
            category.setName("jms");
        }
        return bean;

        // 报错
//        Category category = (Category) bean;
//        category.setName("xxx");
//        return category;
    }

}
