package com.example.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author: chunmu
 * @Date: 2020/6/19 17:20
 * @Description:
 */
@Component
public class A implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("A init");
    }
}
