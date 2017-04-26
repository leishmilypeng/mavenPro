package com.lp.test.pkg;

/**
 * Created by CPR161 on 2017-01-09.
 * 受保护属性及方法
 */
public class ProtectedTest {
    protected String key;
    protected String value;

    protected void show(){
        System.out.println(key+"-"+value+"-protected");
    }
}
