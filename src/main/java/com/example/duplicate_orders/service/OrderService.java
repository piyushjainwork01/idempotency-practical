package com.example.duplicate_orders.service;

import com.example.duplicate_orders.model.Order;
import com.example.duplicate_orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Order createOrder(String product, String key) {

        Optional<Order> existing =
                repository.findByIdempotencyKey(key);

        if(existing.isPresent()) {
            return existing.get();
        }

        Order order = new Order();
        order.setProduct(product);
        order.setIdempotencyKey(key);

        return repository.save(order);
    }
}