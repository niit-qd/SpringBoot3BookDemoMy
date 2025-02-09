package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RabbitMqConfig {

    public RabbitMqConfig() {
        log.info("RabbitMqConfig");
    }

    @Bean
    public Queue testQueue() {
        log.info("");
        return new Queue("test-direct-exchange");
    }

    @Bean
    public DirectExchange testDirectExchange() {
        log.info("");
        return new DirectExchange("test-direct-exchange");
    }

    @Bean
    public Binding testDirectQueue(Queue testDirectQueue, DirectExchange testDirectExchange) {
        log.info("testDirectQueue = {}, testDirectExchange = {}", testDirectQueue, testDirectExchange);
        return BindingBuilder.bind(testDirectQueue).to(testDirectExchange).with("test-direct-routing-key");
    }
}
