package org.example.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisCommandLineRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(RedisCommandLineRunner.class);

    private final RedisTemplate<Object, Object>  redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    public RedisCommandLineRunner(RedisTemplate<Object, Object> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        ValueOperations<Object, Object>  valueOperations = redisTemplate.opsForValue();
        valueOperations.set("test", "" + System.currentTimeMillis() + "-sfdsfdsfjldsfjdsl0000000000000000fjdslkfj");
        logger.info("get value:{}, {}", "test", valueOperations.get("test"));

        ValueOperations<String,String> stringValueOperations = stringRedisTemplate.opsForValue();
        stringValueOperations.set("test_string", "" + System.currentTimeMillis());
        logger.info("get value:{}, {}", "test_string", stringValueOperations.get("test_string"));
    }
}
