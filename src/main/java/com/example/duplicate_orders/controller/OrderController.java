package com.example.duplicate_orders.controller;

import com.example.duplicate_orders.model.Order;
import com.example.duplicate_orders.service.OrderServiceBad;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceBad orderServiceBad;

    @PostMapping
    public Order create(@RequestParam String product) {
        return orderServiceBad.createOrder(product);
    }
}