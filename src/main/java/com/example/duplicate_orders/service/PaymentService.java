package com.example.duplicate_orders.service;

import com.example.duplicate_orders.model.Payment;
import com.example.duplicate_orders.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public void processPayment() {

        savePayment();

        throw new RuntimeException("Payment failed!");
    }

    @Transactional
    public void savePayment() {

        Payment p = new Payment();
        p.setUsername("Piyush");
        p.setAmount(100);

        paymentRepository.save(p);
    }
}