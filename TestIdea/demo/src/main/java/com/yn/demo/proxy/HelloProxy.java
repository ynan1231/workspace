package com.yn.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloProxy implements InvocationHandler {
    private Object target;
    public HelloProxy(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理");
        if (true){
//            throw new Throwable("throwable-----");
        }
        return method.invoke(target,args);
    }
}
