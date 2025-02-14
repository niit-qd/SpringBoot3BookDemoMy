package org.example.controller;

import lombok.extern.log4j.Log4j2;
import org.example.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
@Log4j2
public class MyController {

    @RequestMapping("/hello")
    public ResponseResult<String> hello(@RequestParam("name") String name) {
        log.info("hello {}", name);
        String data = "Hello " + name + "!";
        ResponseResult<String> result = new ResponseResult<>();
        result.setCode(1);
        result.setMessage(name);
        result.setData(data);
        return result;
    }
}
