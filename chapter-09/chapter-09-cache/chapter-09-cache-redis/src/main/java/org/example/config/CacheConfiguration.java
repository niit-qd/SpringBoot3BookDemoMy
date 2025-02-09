package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.time.Duration;

@Slf4j
@Configuration
public class CacheConfiguration {
    public CacheConfiguration() {
        log.info("CacheConfiguration");
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return builder -> {
            builder
                    .withCacheConfiguration("multiple", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(5)))
                    .withCacheConfiguration("plus", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(10)))
                    .withCacheConfiguration("random", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(18)));
            log.info("build cache manager = {}", builder);

        };
    }
}
