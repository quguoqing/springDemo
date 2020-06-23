package com.example.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: chunmu
 * @Date: 2020/6/23 21:31
 * @Description:
 */
public class CFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {

        return new B();
    }

    @Override
    public Class<?> getObjectType() {
        return B.class;
    }
}
