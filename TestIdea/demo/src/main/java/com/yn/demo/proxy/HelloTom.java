package com.yn.demo.proxy;

public class HelloTom implements  Hello {

    @Override
    public void say() {
        System.out.println("hello,Tom");
    }
}
