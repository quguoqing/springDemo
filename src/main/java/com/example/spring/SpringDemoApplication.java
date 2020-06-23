package com.example.spring;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.example.spring.mapper.OrderMapper;
import com.example.spring.mapper.UserMapper;

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

        Object o = context.getBean("cFactoryBean");
        System.out.println(o);

        Object o1 = context.getBean("&cFactoryBean");
        System.out.println(o1);

        OrderMapper orderMapper = (OrderMapper) context.getBean("orderMapper");
        System.out.println(orderMapper.selectByOrderNo("1"));

        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        System.out.println(userMapper.selectByUid(2L));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
