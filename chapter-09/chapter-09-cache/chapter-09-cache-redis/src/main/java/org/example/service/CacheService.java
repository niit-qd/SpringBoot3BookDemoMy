package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Slf4j
@Service
public class CacheService {
    public CacheService() {
        log.info("CacheService");
    }

    @Cacheable(value = "multiple")
    public int multiply(int a, int b) {
        int c = a * b;
        log.info("multiply called. a = {}, b = {}, c = {}", a, b, c);
        return c;
    }

    @Cacheable(value = "plus")
    public int plus(int a, int b) {
        int c = a + b;
        new Date();
        log.info("plus called. a = {}, b = {}, c = {}", a, b, c);
        return c;
    }

    @Cacheable(value = "random")
    public int random(int a, int b) {
        int c = a + b + ((int) Math.round(Math.random() * 10));
        log.info("random called. a = {}, b = {}, c = {}", a, b, c);
        return c;
    }
}
