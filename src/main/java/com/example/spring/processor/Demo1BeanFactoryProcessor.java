package com.example.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author: chunmu
 * @Date: 2020/6/19 17:27
 * @Description:
 */
@Component
public class Demo1BeanFactoryProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("a");
        if(null != beanDefinition){
            System.out.println("class A beanDef postProcessBeanFactory");
        }
    }
}
