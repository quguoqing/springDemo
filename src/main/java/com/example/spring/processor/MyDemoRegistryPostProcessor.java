package com.example.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import com.example.spring.B;
import com.example.spring.CFactoryBean;
import com.example.spring.MapperFactoryBean;
import com.example.spring.mapper.OrderMapper;
import com.example.spring.mapper.UserMapper;

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

            BeanDefinition cFactoryBean = new GenericBeanDefinition();
            cFactoryBean.setBeanClassName("cFactoryBean");
            ((GenericBeanDefinition) cFactoryBean).setBeanClass(CFactoryBean.class);
            registry.registerBeanDefinition("cFactoryBean", cFactoryBean);

            //把mapper的BeanDef注册
            //其实mybatis，也是通过MapperScannerRegistrar把mapper接口通过FactoryBean的形式注入到容器。
            //只是没想到我自己生成的最简单的BeanDefinition，竟然也能实例化成bean.
            //优化：1、这里RegistryPostProcessor，可以用包路径进行扫描，然后for循环创建bean。无需这里依次创建
            //2、setBeanClass和addGenericArgumentValue，是一定不能少的。spring在创建MapperFactoryBean实例的时候会调用构造方法。
            BeanDefinition orderMapper = new GenericBeanDefinition();
            orderMapper.setBeanClassName("orderMapper");
            ((GenericBeanDefinition) orderMapper).setBeanClass(MapperFactoryBean.class);
            orderMapper.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);

            BeanDefinition userMapper = new GenericBeanDefinition();
            userMapper.setBeanClassName("userMapper");
            ((GenericBeanDefinition) userMapper).setBeanClass(MapperFactoryBean.class);
            userMapper.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);

            registry.registerBeanDefinition("orderMapper", orderMapper);
            registry.registerBeanDefinition("userMapper", userMapper);
        }
        System.out.println("after MyDemoRegistryPostProcessor bean size=" + registry.getBeanDefinitionCount());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        System.out.println("我是一条咸鱼");
    }
}
