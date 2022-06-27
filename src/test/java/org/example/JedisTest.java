package org.example;

import lombok.extern.slf4j.Slf4j;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

@Slf4j
public class JedisTest
{
    private Jedis jedis;
    @Before
    public void init() {
        jedis = new Jedis("127.0.0.1",6379);
    }

    @Test
    public void getDB0(){
        jedis.select(0);
        Set<String> keys = jedis.keys("*");
        for (String key:keys) {
            System.out.println("(k,v)=("+key+","+jedis.get(key)+")");
        }
    }

    @Test
    public void testString(){
        jedis.select(0);
    }
    @Test
    public void testList(){
        jedis.select(1);
        jedis.keys("*").forEach(System.out::println);
    }
    @Test
    public void testSet(){
        jedis.select(2);
        jedis.keys("*").forEach(System.out::println);
    }
    @Test
    public void testHash(){
        jedis.select(3);
        jedis.keys("*").forEach(System.out::println);
    }
    @Test
    public void testSortedSet(){
        jedis.select(4);
        jedis.keys("*").forEach(System.out::println);
    }
    @Test
    public void testCommands(){
        jedis.select(5);
        jedis.keys("*").forEach(System.out::println);
    }


    @After
    public void close(){
        if(jedis!=null){
            jedis.close();
        }
    }
}
