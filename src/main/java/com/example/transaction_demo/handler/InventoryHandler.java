package com.example.transaction_demo.handler;

import org.springframework.stereotype.Service;

import com.example.transaction_demo.entity.Product;
import com.example.transaction_demo.repository.InventoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryHandler {
    
    private InventoryRepository inventoryRepository;

    public Product updateProductDetails(Product product){
        return inventoryRepository.save(product);
    }

    public Product getProduct(int id){
        return inventoryRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Product not found")
                );
    }


}
