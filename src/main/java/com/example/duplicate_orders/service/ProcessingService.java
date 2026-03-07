package com.example.duplicate_orders.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProcessingService {

    @Async("taskExecutor")
    public void processOrder(int orderId) {

        System.out.println("Processing order " + orderId +
                " Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}