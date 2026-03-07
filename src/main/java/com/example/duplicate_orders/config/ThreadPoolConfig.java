package com.example.duplicate_orders.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Config class mein bean banao
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService executorService() {
        return new ThreadPoolExecutor(
                3,                          // core pool size
                10,                         // max pool size
                60L, TimeUnit.SECONDS,      // idle thread timeout
                new LinkedBlockingQueue<>(100),  // task queue capacity
                new ThreadPoolExecutor.CallerRunsPolicy()  // rejection policy
        );
    }
}