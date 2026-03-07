package com.example.duplicate_orders.repository;

import com.example.duplicate_orders.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
        SELECT u FROM User u
        JOIN FETCH u.orders
    """)
    List<User> findAllWithOrders();


    @EntityGraph(attributePaths = {"orders"})
    List<User> findAll();
}
