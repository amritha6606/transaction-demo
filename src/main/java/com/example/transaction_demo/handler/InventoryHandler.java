package com.example.transaction_demo.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transaction_demo.entity.Product;
import com.example.transaction_demo.repository.InventoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryHandler {
    
    private InventoryRepository inventoryRepository;

    @Transactional
    public Product updateProductDetails(Product product){
          //throws exception to test @Transactional
        if(product.getPrice()>5000){
            throw new RuntimeException("DB Crashed");
        }
        return inventoryRepository.save(product);
    }

    public Product getProduct(int id){
        return inventoryRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Product not found")
                );
    }


}
