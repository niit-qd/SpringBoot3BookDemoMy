package org.example.config;

import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskConfig {
    @Lazy
    @Bean
    public ThreadPoolTaskExecutor taskExecutor(TaskExecutionProperties properties) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        PropertyMapper mapper = PropertyMapper.get().alwaysApplyingWhenNonNull();
        TaskExecutionProperties.Pool pool = properties.getPool();
        mapper.from(pool::getQueueCapacity).to(executor::setQueueCapacity);
        return executor;
    }
}
