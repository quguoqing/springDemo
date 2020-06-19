package com.example.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.example.spring.B;

/**
 * @author: chunmu
 * @Date: 2020/6/19 17:30
 * @Description: 修改beanDef
 */
@Component
public class AddBeanFactoryProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        BeanDefinition aBeanDef = beanFactory.getBeanDefinition("a");
        System.out.println("before aBeanDef.class=" + aBeanDef.getBeanClassName());
        // aBeanDef.setBeanClassName(B.class.getName());
        // System.out.println("change aBeanDef.class=" + aBeanDef.getBeanClassName());
    }
}
