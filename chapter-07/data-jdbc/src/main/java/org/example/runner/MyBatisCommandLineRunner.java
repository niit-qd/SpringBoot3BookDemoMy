package org.example.runner;

import org.example.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class MyBatisCommandLineRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(MyBatisCommandLineRunner.class);

    private final ActorService actorService;

    public MyBatisCommandLineRunner(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("actorService.findById({}) = {}", 12, actorService.findById(12));
        logger.info("actorService.findAll() = {}", actorService.findAll());
        logger.info("actorService.updateFirstNameById({}, {}) = {}", 201, "李", actorService.updateFirstNameById(201, "李"));
    }
}
