package com.lp.test.proxy;

/**
 * Created by CPR161 on 2016-12-14.
 * 属于静态代理
 */
public class StaticSubject implements Subject{

    RealSubject realSubject = new RealSubject();
    public void request() {
        System.out.println("before request...");
        realSubject.request();
        System.out.println("after request...");
    }
}
