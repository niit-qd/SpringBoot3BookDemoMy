package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
@Slf4j
public class KafkaConfig {
    public static final String SPRING_BOOT_TEST_TOPIC = "spring-boot-test-topic";

    @Bean
    public NewTopic springBootTestTopic() {
        log.info("Create new topic [{}]", SPRING_BOOT_TEST_TOPIC);
        return new NewTopic(SPRING_BOOT_TEST_TOPIC, 4, (short) 2);
    }

    @Bean
    public KafkaAdmin.NewTopics springBootTestTopics(NewTopic springBootTestTopic) {
        log.info("Create new topics {}", springBootTestTopic);
        return new KafkaAdmin.NewTopics(springBootTestTopic);
    }
}
