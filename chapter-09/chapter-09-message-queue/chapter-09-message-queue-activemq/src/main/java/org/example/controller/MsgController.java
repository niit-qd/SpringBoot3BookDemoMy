package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MsgController {

    private final JmsTemplate jmsTemplate;

    @RequestMapping("/send")
    public String sendMsg(@RequestParam("msg") String msg) {
        jmsTemplate.convertAndSend("test-direct-exchange", msg);
        return "success";
    }

    @JmsListener(destination = "test-direct-exchange")
    public void receivedMsg(String msg) {
        log.info("receivedMsg {}", msg);
    }

}
