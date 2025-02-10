package org.example.controller.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.config.KafkaConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(path = "/kafka/producer")
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

//    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate) {
//        log.info("KafkaProducerController start");
//        this.kafkaTemplate = kafkaTemplate;
//    }

    @RequestMapping(path = "/send")
    public String send(@RequestParam(name = "message") String message) {
        log.info("send message: {}", message);
        int key = new Random().nextInt(100) % 4;
        String topic = KafkaConfig.SPRING_BOOT_TEST_TOPIC;
        String kafkaKey = "key-" + key;
        kafkaTemplate.send(topic, kafkaKey, message);
        log.info("send message: topic = {}, key = {}, message = {}", topic, kafkaKey, message);
        return "success";
    }

    @RequestMapping(path = "/send_multiple")
    public String sendMultiple(@RequestParam(name = "message") String message, @RequestParam(name = "count", defaultValue = "10") int count) {
        log.info("send message: {}, count = {}", message, count);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10000);
        executor.setQueueCapacity(10);
        executor.initialize();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            executor.submit(() -> {
                int key = random.nextInt(100) % 4;
                String topic = KafkaConfig.SPRING_BOOT_TEST_TOPIC;
                String kafkaKey = "key-" + key;
                String newMessage = message + "-" + random.nextInt(10000);
                kafkaTemplate.send(topic, kafkaKey, newMessage);
                log.info("send message: topic = {}, key = {}, newMessage = {}", topic, kafkaKey, newMessage);
            });
        }
        executor.shutdown();
        return "success";
    }

}
