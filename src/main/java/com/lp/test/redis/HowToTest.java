package com.lp.test.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by CPR161 on 2016-11-15.
 */
public class HowToTest {
    public static void main(String[] args) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("10.0.12.90", 6379);
            jedis.set("key", "leipeng");
            String rs = jedis.get("key");
            System.out.println(rs);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
