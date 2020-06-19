package com.example.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import com.example.spring.B;

/**
 * @author: chunmu
 * @Date: 2020/6/19 17:34
 * @Description:
 */
@Component
public class MyDemoRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * 注册一个B的bean
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
            throws BeansException {
        int size = registry.getBeanDefinitionCount();
        System.out.println("before MyDemoRegistryPostProcessor bean size=" + size);
        if(!registry.containsBeanDefinition("b")){
            //这里我自己生成的beanDef，其实是不可以的。B本来不在spring管理，我这里强制管理B
            BeanDefinition b = new GenericBeanDefinition();
            b.setBeanClassName(B.class.getName());
            registry.registerBeanDefinition("bbbbb", b);
        }
        System.out.println("after MyDemoRegistryPostProcessor bean size=" + registry.getBeanDefinitionCount());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        System.out.println("我是一条咸鱼");
    }
}
