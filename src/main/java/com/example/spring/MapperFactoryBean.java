package com.example.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author: chunmu
 * @Date: 2020/6/23 22:02
 * @Description:
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> curInterface;

    public MapperFactoryBean(Class curInterface){
        this.curInterface = curInterface;
    }

    @Override
    public T getObject() throws Exception {

        T o = (T) Proxy.newProxyInstance(curInterface.getClassLoader(), new Class[]{this.curInterface}, new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                return args[0];
            }
        });

        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return this.curInterface.getClass();
    }
}
