package com.walruscode.examples.executor_service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;


/*
    It is interesting to know, that in Spring Boot class TaskExecutorConfigurations.java there is
    an annotation like @ConditionalOnMissingBean(Executor.class). Whenever this class is not defined
    by the programmer, then Spring Boot creates either a SimpleAsyncTaskExecutor or a
    ThreadPoolTaskExecutor, based on the Threading mode: Virtual or Platform

    see @ConditionalOnThreading(Threading.VIRTUAL)
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ExecutorServiceExample {

    private final ThreadPoolTaskExecutor executor;

    @PostConstruct
    public void backgroundTasks() {

        log.info("Starting background jobs");

        executor.execute(() -> {
            try {
                Thread.sleep(5000);

                log.info("Waking up! v1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(() -> {
            try {
                Thread.sleep(5000);

                log.info("Waking up! v2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        log.info("Submited background jobs");
    }
}
