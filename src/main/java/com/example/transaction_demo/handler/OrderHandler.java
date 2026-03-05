package com.example.transaction_demo.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transaction_demo.entity.Order;
import com.example.transaction_demo.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderHandler {
    
    private OrderRepository orderRepository;

    @Transactional
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
    
}
