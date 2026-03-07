package com.example.duplicate_orders.repository;

import com.example.duplicate_orders.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByIdempotencyKey(String key);
    Page<Order> findByUserId(Long userId, Pageable pageable);
}
