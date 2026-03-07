package com.example.duplicate_orders.service;

import com.example.duplicate_orders.model.User;
import com.example.duplicate_orders.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){

        List<User> users = userRepository.findAll();

        users.forEach(user -> {
            System.out.println(user.getOrders().size());
        });

        return users;
    }
}
