package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {
    @RequestMapping("/say")
    public String sayHello(@RequestParam(name = "name") String name) {
        return "Hello " + name;
    }
}
