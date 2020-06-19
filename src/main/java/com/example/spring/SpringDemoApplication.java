package com.example.spring;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: chunmu
 * @Date: 2020/6/19 17:14
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.example.spring")
public class SpringDemoApplication implements ApplicationContextAware {

    private static ApplicationContext context;

    public static void main(String[] args){
        SpringApplication.run(SpringDemoApplication.class, args);
        String[] beanNames = context.getBeanDefinitionNames();
        // for(String bean : beanNames){
        //     Object bbbb = context.getBean(bean);
        //     System.out.println(bean + ":" + bbbb);
        // }
        Object object = context.getBean("bbbbb");
        System.out.println("bbbbb" + ":" + object);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
