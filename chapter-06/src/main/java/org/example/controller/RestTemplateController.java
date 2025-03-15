package org.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    Logger logger = LoggerFactory.getLogger(RestTemplateController.class);

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/weather/{city_id}")
    public String weather(@PathVariable(name = "city_id") String cityId) {
        logger.info("cityId = {}", cityId);
        String url = "http://t.weather.itboy.net/api/weather/city/" + cityId;
        String result = restTemplateBuilder.build().getForObject(url, String.class);
        return result;
    }


    @RequestMapping("/weather2/{city_id}")
    public Mono<String> weather2(@PathVariable(name = "city_id") String cityId) {
        logger.info("cityId = {}", cityId);
        String url = "http://t.weather.itboy.net/api/weather/city/" + cityId;
        Mono<String> result = webClientBuilder.build().get().uri(url).retrieve().bodyToMono(String.class);
        return result;
    }

}
