package org.example.consumer;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.config.KafkaConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = {KafkaConfig.SPRING_BOOT_TEST_TOPIC})
    public void listen(ConsumerRecord<String, String> record) {
        log.info(record.toString());
    }
}
