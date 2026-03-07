package com.example.duplicate_orders.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

// Service mein inject karo
@Service
@Slf4j
public class CounterService {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final ExecutorService executorService;

    public CounterService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void incrementAsync() {
        executorService.submit(() -> {
            try {
                counter.incrementAndGet();
            } catch (Exception e) {
                log.error("Counter increment failed", e);
            }
        });
    }

    public int getCount() {
        return counter.get();
    }
}