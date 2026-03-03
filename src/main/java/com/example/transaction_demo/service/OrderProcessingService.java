package com.example.transaction_demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.transaction_demo.entity.Order;
import com.example.transaction_demo.entity.Product;
import com.example.transaction_demo.handler.InventoryHandler;
import com.example.transaction_demo.handler.OrderHandler;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderProcessingService {
    
    private InventoryHandler inventoryHandler;
    private OrderHandler orderHandler;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Order placeOrder(Order order){
    
        //get Product Inventory
        Product product = inventoryHandler.getProduct(order.getProductId());

        validateStockInventory(product, order);        

        //update total price in order entity
        order.setTotalPrice(product.getPrice()*order.getQuantity());

        //save order
        Order savedOrder = orderHandler.saveOrder(order);

        updateStockInventory(product, order);

        return savedOrder;
    }

    private void validateStockInventory(Product product, Order order){
        //validate the stock availability
        if(order.getQuantity() > product.getStockQuantity()){
            throw new RuntimeException("Insufficient Stock! ");
        }
    }

    private void updateStockInventory(Product product, Order order){

        //throws exception to test @Transactional
        if(product.getPrice()>5000){
            throw new RuntimeException("DB Crashed");
        }

        //update stock in inventory
        int availableQuantity = product.getStockQuantity() - order.getQuantity();
        product.setStockQuantity(availableQuantity);
        inventoryHandler.updateProductDetails(product);
    }
}
