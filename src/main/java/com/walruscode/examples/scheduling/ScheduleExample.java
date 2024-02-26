package com.walruscode.examples.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@Slf4j
public class ScheduleExample {

    @Scheduled(cron = "* */10 * * * *")
    public void printMsg() {
        log.info("executed scheduled job");
    }
}
