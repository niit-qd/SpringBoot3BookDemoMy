package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.CacheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CacheController {

    private final CacheService cacheService;

    @RequestMapping("/multiple")
    public int multiple(@RequestParam("a") int a, @RequestParam("b") int b) {
        return cacheService.multiply(a, b);
    }

    @RequestMapping("/plus")
    public int plus(@RequestParam("a") int a, @RequestParam("b") int b) {
        return cacheService.plus(a, b);
    }

    @RequestMapping("/random")
    public int random(@RequestParam("a") int a, @RequestParam("b") int b) {
        return cacheService.random(a, b);
    }

}
