package com.yn.demo.refer;

public class Test {
    public static void main(String[] args) {
        int a =1;
        int b=2;
        int c=3;
        a=b=c;
        System.out.println(String.format("%d,%d,%d",a,b,c));
    }
}
