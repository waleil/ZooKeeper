package com.cui.stu.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @Auther: csx
 * @Date: 2022/9/15 22:45
 * @Description:
 */
public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.101",6379);

        String value = jedis.ping();
        System.out.println(value);

    }
    @Test
    public void demo(){
        Jedis jedis = new Jedis("192.168.0.101",6379);
        jedis.set("name", "lucy");
        System.out.println(jedis.get("name"));

        jedis.mset("k1","v1","k2","v2");
        System.out.println(jedis.mget("k1","k2"));
        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);
    }
}
