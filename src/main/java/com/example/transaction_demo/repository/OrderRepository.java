package com.example.transaction_demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transaction_demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
