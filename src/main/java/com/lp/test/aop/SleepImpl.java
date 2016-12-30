package com.lp.test.aop;

/**
 * Created by CPR161 on 2016-12-13.
 */
public class SleepImpl implements Sleepable {
    public void sleep() {
        System.out.println("乖,该睡觉了！");
    }

    public void beginsleep() {
        System.out.println("开始睡觉了！");
    }
}
