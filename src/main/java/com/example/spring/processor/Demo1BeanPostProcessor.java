package com.example.spring.processor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: chunmu
 * @Date: 2020/6/19 17:21
 * @Description:
 */
@Component
public class Demo1BeanPostProcessor implements BeanPostProcessor {

    private static Set<String> needCheck = new HashSet<>();

    static {
        needCheck.add("a");
        needCheck.add("bbbb");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(needCheck.contains(beanName) ){
            System.out.println("执行 " + beanName + " postProcessBeforeInitialization");
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(needCheck.contains(beanName)){
            System.out.println("执行 " + beanName + " postProcessAfterInitialization");
        }
        return bean;
    }

}
