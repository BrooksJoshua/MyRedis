package org.example.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-27 16:48
 */
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(8);
        config.setMaxIdle(8);
        config.setMinIdle(0);
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);

    }

    public static Jedis getInstance() {
        return jedisPool.getResource();
    }
}