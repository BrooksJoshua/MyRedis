package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-27 17:08
 */
@SpringBootTest
public class SpringDataRedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test(){
        System.out.println(redisTemplate.getKeySerializer());
        System.out.println(redisTemplate.getHashValueSerializer());
        redisTemplate.opsForValue().set("name","张三");//
        System.out.println("name = " + redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void testSaveUser(){
        String key = "user:100";
        redisTemplate.opsForValue().set(key,new User("熏悟空",500));
        User user = (User) redisTemplate.opsForValue().get(key);
        System.out.println("user = " + user);
    }

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSaveUserWithStringRedisTemplate() throws JsonProcessingException {
        String key = "user:200";
        User user = new User("熏悟空", 500);
        String serializedUser = mapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set(key,serializedUser);
        String o = stringRedisTemplate.opsForValue().get(key);
        User userDeserialized = mapper.readValue(o,User.class);
        System.out.println("userDeserialized = " + userDeserialized);
    }

}