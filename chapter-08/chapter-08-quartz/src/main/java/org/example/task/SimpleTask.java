package org.example.task;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class SimpleTask extends QuartzJobBean {
    private static int instanceCount;
    private int jobExecutedCount;

    public SimpleTask() {
        instanceCount++;
    }

    @Override
    protected void executeInternal(@NonNull JobExecutionContext context) throws JobExecutionException {
        jobExecutedCount++;
        log.info("instanceCount = {}, jobExecutedCount= {}", instanceCount, jobExecutedCount);
    }
}
