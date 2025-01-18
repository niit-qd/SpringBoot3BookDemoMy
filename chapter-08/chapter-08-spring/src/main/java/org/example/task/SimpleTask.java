package org.example.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class SimpleTask {
    private int index = 0;
    private int index2 = 0;

    @Scheduled(cron = "*/3 * * * * *")
    public void printTask() {
        index++;
        log.info("{}: time={}", index, new Date());
    }

    @Async
    @Scheduled(cron = "*/3 * * * * *")
    public void printTask2() {

        index2++;
        log.info("{}: time={}", index2, new Date());
    }
}
