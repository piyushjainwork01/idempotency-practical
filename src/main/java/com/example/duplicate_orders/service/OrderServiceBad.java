package com.example.duplicate_orders.service;

import com.example.duplicate_orders.model.Order;
import com.example.duplicate_orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceBad {

    private final OrderRepository repository;

    public Order createOrder(String product) {

        Order order = new Order();
        order.setProduct(product);

        return repository.save(order);
    }
}
