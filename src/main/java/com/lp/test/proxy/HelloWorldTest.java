package com.lp.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

import com.lp.biz.service.ITmUserService;
import com.lp.biz.service.impl.TmUserServiceImpl;

public class HelloWorldTest {
	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorldImpl();
		InvocationHandler handler = new ProxyHandler(helloWorld);

		// 创建动态代理对象
		//HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), handler);
		//proxy.sayHelloWorld();
		HelloWorldTest hwTest = new HelloWorldTest();
		hwTest.test();
	}
	
	
	
	public void test(){
		ITmUserService userService = new TmUserServiceImpl();
		InvocationHandler handler = new ProxyHandler(userService);
		
		ITmUserService proxy = (ITmUserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);
		List list = proxy.getList(new HashMap<String,Object>());
		System.out.println("");
	}
}
