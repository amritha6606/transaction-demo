package com.example.transaction_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transaction_demo.entity.Product;

public interface InventoryRepository extends JpaRepository<Product, Integer> {
    
}
