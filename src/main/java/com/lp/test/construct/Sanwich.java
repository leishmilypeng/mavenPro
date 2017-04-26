package com.lp.test.construct;

/**
 * Created by CPR161 on 2017-01-23.
 *
 *  多层次继承的时候类的构造顺序
 *  1.调用基类的构造器，优先构造基类，反复递归下去直到最底层
 *  2.按照申明顺序调用成员的初始化方法
 *  3.调用导出类构造器主题
 *
 */
public class Sanwich extends PortableLunch {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();
    public Sanwich(){
        System.out.println("Sanwich()");
    }

    public static void main(String[] args) {
        new Sanwich(); // 构造器打印顺序如下
    }

    /*
    Meal()
    Lunch()
    PortableLunch()
    Bread()
    Cheese()
    Lettuce()
    Sanwich()
    */
}
