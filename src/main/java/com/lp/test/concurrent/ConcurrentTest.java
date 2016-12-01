package com.lp.test.concurrent;

import java.util.concurrent.*;

/**
 * Created by CPR161 on 2016-11-18.
 */
public class ConcurrentTest {

    public static void main(String[] args) {
        ArrayBlockingQueue abq = new ArrayBlockingQueue(10);
        Object o = new Object();
       // o.equals();
        System.out.printf("");
        ConcurrentTest   ct  = new ConcurrentTest( );
        ct.test();

    }

    public void  test(){
        Executor executor = Executors.newFixedThreadPool(10);
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("task over");
            }
        };
        executor.execute(task);

        executor = Executors.newScheduledThreadPool(10);
        ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;
        scheduler.scheduleAtFixedRate(task, 10, 10, TimeUnit.SECONDS);
    }

    public  class  CallableTest implements Callable {

        public String call() throws Exception {
            return "执行完毕";
        }
    }

}
