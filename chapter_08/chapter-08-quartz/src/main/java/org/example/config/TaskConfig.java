package org.example.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.example.task.SimpleTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TaskConfig {
    @Bean
    public JobDetail simpleTask() {
        return JobBuilder
                .newJob(SimpleTask.class)
                .withIdentity("simple-task")
                .withDescription("SimpleTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger simpleTaskTrigger(JobDetail simpleTask) {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                .cronSchedule("0/3 * * * * ? *");
        return TriggerBuilder
                .newTrigger()
                .withIdentity("simple-task-trigger")
                .withDescription("SimpleTaskTrigger")
                .forJob(simpleTask)
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    @PostConstruct
    public void init() {
        log.info("init");
    }

    @PreDestroy
    private void teardown() {

    }
}
