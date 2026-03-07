package com.example.duplicate_orders.service;

import com.example.duplicate_orders.model.Order;
import com.example.duplicate_orders.model.User;
import com.example.duplicate_orders.repository.OrderRepository;
import com.example.duplicate_orders.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

//    @Override
//    public void run(String... args) {
//
//        for(int i=1;i<=5;i++){
//
//            User user = new User();
//            user.setName("User"+i);
//
//            userRepository.save(user);
//
//            for(int j=1;j<=3;j++){
//
//                Order order = new Order();
//                order.setProduct("Product"+j);
//                order.setUser(user);
//
//                orderRepository.save(order);
//            }
//        }
//    }

    @Override
    public void run(String... args) {

        User user = new User();
        user.setName("TestUser");

        userRepository.save(user);

        for(int i=1;i<=50000;i++){

            Order order = new Order();
            order.setProduct("Product"+i);
            order.setUser(user);

            orderRepository.save(order);
        }
    }





}
