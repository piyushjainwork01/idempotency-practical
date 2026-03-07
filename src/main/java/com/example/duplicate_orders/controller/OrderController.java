package com.example.duplicate_orders.controller;

import com.example.duplicate_orders.model.Order;
import com.example.duplicate_orders.service.OrderServiceBad;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceBad orderServiceBad;

    @PostMapping
    public Order create(@RequestParam String product) {
        return orderServiceBad.createOrder(product);
    }

    @GetMapping
    public Page<Order> getOrders(@RequestParam Long userId) {
        return orderServiceBad.getOrdersByUser(userId);
    }
}