package com.walruscode.examples.executor_service;

import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {

    /**
     * This is the builder Spring Boot will use by default if no other Executor.java
     * was implemented.
     */
    @Bean
    public ThreadPoolTaskExecutorBuilder threadPoolTaskExecutorBuilder() {
        return new ThreadPoolTaskExecutorBuilder().maxPoolSize(10).corePoolSize(10);
    }
}
