package org.example.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MongoDemoCommandLineRunner implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(MongoDemoCommandLineRunner.class);

    private final MongoTemplate mongoTemplate;

    public MongoDemoCommandLineRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> objectToSave = new HashMap<>();
        objectToSave.put("name", "张三");
        objectToSave.put("gender", "male");
        objectToSave.put("age", 24);
        String collectionName = "hw";
        Map<String, Object> insertedObject = mongoTemplate.insert(objectToSave, collectionName);
        logger.info("insertedObject = {}", insertedObject);

        List<?> convertedCollection = mongoTemplate.findAll(Object.class);
        logger.info("convertedCollection = {}", convertedCollection);
    }
}
