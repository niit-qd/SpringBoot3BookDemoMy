package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MsgController {
    private final RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String sendMsg(@RequestParam("msg") String msg) {
        log.info("send msg: {}", msg);
        rabbitTemplate.convertAndSend("test-direct-exchange", "msg", msg);
        return "success";
    }

    @RabbitListener(queues = {"test-direct-exchange"})
    public void listener(String msg) {
        log.info("msg: {}", msg);
    }
}
