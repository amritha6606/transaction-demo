package com.example.transaction_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.transaction_demo.entity.Order;
import com.example.transaction_demo.service.OrderProcessingService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OrderProcessingController {
    
    private OrderProcessingService orderProcessingService;

    @PostMapping 
    public ResponseEntity<Order> placeOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderProcessingService.placeOrder(order), HttpStatus.OK);
    }
}
