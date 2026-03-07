package com.example.duplicate_orders.service;

import com.example.duplicate_orders.model.Order;
import com.example.duplicate_orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceBad {

    private final OrderRepository repository;

    public Order createOrder(String product) {

        Order order = new Order();
        order.setProduct(product);

        return repository.save(order);
    }

    public Page<Order> getOrdersByUser(Long userId) {
        Pageable pageable = PageRequest.of(0,20);
        return repository.findByUserId(userId,pageable);
    }
}
