package com.lp.test.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by CPR161 on 2016-12-13.
 * 定义一个睡眠的增强 同时实现前置 和后置
 */
public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("睡觉前要敷面膜");
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("睡觉后要做美梦");
    }
}
