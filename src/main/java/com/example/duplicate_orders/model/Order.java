package com.example.duplicate_orders.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "orders",indexes = {
        @Index(name = "idx_user_id",columnList = "user_id")
})
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String product;

    private String idempotencyKey;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}