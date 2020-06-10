package com.yn.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {

        try {
            Hello hello;
            HelloTom target = new HelloTom();
            InvocationHandler helloProxy = new HelloProxy(target);
            /**
             * ClassLoader loader,
             *  @NotNull Class<?>[] interfaces, 类实现的接口集合,也可以用具体类的  HelloTom.class.getInterfaces()
             *  @NotNull reflect.InvocationHandler h
             */
            hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class},helloProxy);
            hello.say();

            hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    //动态代理类可以什么也不用做,也可以代理某个对象,通过反射method.invoke(object,args)执行对象方法
                    System.out.println("自定义proxy");
                    return null;
                }
            });
            hello.say();


        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("catch you!");
        }
        System.out.println("end");
    }
}
