package com.lp.test.extend;

/**
 * Created by CPR161 on 2017-01-23.
 * 此例子容易让人混淆，一般程序不会按照如此写法
 *
 * Super.field 和 Sub.field 分配了不同的空间，属于类常量
 *
 * Java虚拟机 方法区：
 *  用于存储被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据
 *
 */
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.println(sup.field+"--"+sup.getField());

        Sub sub = new Sub();
        System.out.println(sub.field+"--"+sub.getField()+"--"+sub.getSuperField());
    }
}
