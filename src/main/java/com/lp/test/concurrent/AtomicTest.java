package com.lp.test.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by CPR161 on 2017-02-10.
 */
public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger(0);

    public static  void increse(){
        race.addAndGet(1) ;
    }

    public  static  final  int THREAD_COUNT = 20;
    public static void main(String[] args) {

        Thread [] threads = new Thread[THREAD_COUNT];
        for(int i=0;i< THREAD_COUNT;i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for(int j=0;j<100;j++){
                        increse();
                    }
                }
            });
            threads[i].start();
        }
        System.out.println("当前线程数:"+Thread.activeCount()+";race值："+race);
   /*     while(Thread.activeCount()>1){
            Thread.yield();

        }*/
    while(Thread.activeCount()>1){
        Thread.yield();
    }

        int num = Thread.activeCount();
        System.out.println(race+";活动线程数 "+num);

    }
}
