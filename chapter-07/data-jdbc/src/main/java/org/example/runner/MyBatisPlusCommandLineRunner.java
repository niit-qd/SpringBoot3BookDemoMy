package org.example.runner;

import org.example.mybatis.mapper.CityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBatisPlusCommandLineRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(MyBatisPlusCommandLineRunner.class);

    private final CityMapper cityMapper;

    public MyBatisPlusCommandLineRunner(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("mapper = {}", cityMapper);
//        logger.info("city of {} is {}", 12, cityMapper.selectById(12));
    }
}
