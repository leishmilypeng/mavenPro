package com.lp.test.thread;

import com.lp.init.SystemStartupInit;

/**
 * Created by CPR161 on 2016-11-17.
 */
public class Counter {
    public static int count = 0;

    public  static int aliveCnt = 0;

    public synchronized static void inc() {

        //这里延迟1毫秒，使得结果明显
        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }*/

        count++;
    }

    public static void main(String[] args) {

        //同时启动1000个线程，去进行i++计算，看看实际结果

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Counter.inc();
                    Counter.aliveCnt++;
                }

            }).start();
        }

        //这里每次运行的值都有可能不同,可能为1000
        while(true){
            if(Counter.aliveCnt==100){
                System.out.println("运行结果:Counter.count=" + Counter.count);
                break;
            }else{
                System.out.println("已运行完线程数："+Counter.aliveCnt);
            }

        }

    }
}
