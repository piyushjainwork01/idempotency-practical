package com.example.duplicate_orders.controller;

import com.example.duplicate_orders.service.ProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/load")
public class LoadController {

    private final ProcessingService processingService;
    private final Executor taskExecutor;


    @GetMapping
    public ResponseEntity<String> generateLoad(){

        CompletableFuture.runAsync(() -> {
            for(int i=1;i<=100;i++){
                processingService.processOrder(i);
            }
        },taskExecutor);

        return ResponseEntity.ok("Tasks summited");
    }
}
