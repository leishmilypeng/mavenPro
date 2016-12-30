package com.lp.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by CPR161 on 2016-12-14.
 * 动态代理实现类
 */
public class DynamicSubject implements InvocationHandler {

    private Object sub;
    public DynamicSubject(Object sub){
        this.sub = sub;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling " + method);
        method.invoke(sub,args);
        System.out.println("after calling " + method);
        return null;
    }
}
