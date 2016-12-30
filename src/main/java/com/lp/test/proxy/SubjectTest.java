package com.lp.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by CPR161 on 2016-12-14.
 */
public class SubjectTest {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler ih = new DynamicSubject(subject); //初始化代理类
        Subject proxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),ih);
        proxy.request();
    }
}
