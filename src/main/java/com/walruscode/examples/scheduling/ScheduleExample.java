package com.walruscode.examples.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@Slf4j
public class ScheduleExample {

    /**
     * If Spring Boot doesn't find a TaskScheduler in the config, it will define a single
     * threaded executor to run all scheduled jobs, hence they'll run sequentially if waiting
     * in the queue.

     * https://github.com/spring-projects/spring-framework/blob/4.3.x/spring-context/src/main/java/org/springframework/scheduling/config/ScheduledTaskRegistrar.java#L339
     * Although take the previous link with a grain of salt, as this is a newer version of spring boot and things may have changed.
     *
     * https://www.baeldung.com/spring-scheduled-tasks#11-running-tasks-in-parallel
     */

    @Scheduled(cron = "* */10 * * * *")
    public void printMsg() {
        log.info("executed scheduled job");
    }
}
