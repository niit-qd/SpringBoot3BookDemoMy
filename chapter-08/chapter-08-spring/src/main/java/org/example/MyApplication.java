package org.example;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
//                .bannerMode(Banner.Mode.OFF)
                .sources(MyApplication.class)
                .run(args);
    }
}