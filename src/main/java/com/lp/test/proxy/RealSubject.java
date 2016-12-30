package com.lp.test.proxy;

/**
 * Created by CPR161 on 2016-12-14.
 * 实际实现类型
 */
public class RealSubject implements Subject{
    public void request() {
        System.out.println("do request");
    }
}
