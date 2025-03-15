package org.example.controller;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/session")
public class SessionController {

    private Logger logger = LoggerFactory.getLogger(SessionController.class);
    private final HttpSession httpSession;


    public SessionController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @RequestMapping(path = "/set")
    public String set(@RequestParam(name = "name") String name, @RequestParam(name = "value") String value) {
        logger.info("key = {}, value = {}", name, value);
        httpSession.setAttribute(name, value);
        return "{" + name + "," + value + "}";
    }

    @RequestMapping(path = "/get")
    public String get(@RequestParam(name = "name") String name) {
        String value = String.valueOf(httpSession.getAttribute(name));
        logger.info("key = {}, value = {}", name, value);
        return "{" + name + "," + value + "}";
    }
}
