package com.walruscode.examples.countdownlatch;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class LatchExample {

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    @PostConstruct
    public void init() throws InterruptedException {
        List<Integer> numbers = List.of(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        CountDownLatch semaphore = new CountDownLatch(numbers.size());

        AtomicInteger result = new AtomicInteger(0);

        for (int number: numbers) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    result.addAndGet(number);
                    semaphore.countDown();
                }
            });
        }

        log.info("Waiting for threads to work");
        semaphore.await();
        log.info("Finished summing up, result is {}", result.get());
    }
}
