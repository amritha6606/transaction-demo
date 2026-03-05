package com.example.transaction_demo.handler;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.transaction_demo.entity.AuditLog;
import com.example.transaction_demo.entity.Order;
import com.example.transaction_demo.repository.AuditLogRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuditLogHandler {

    private AuditLogRepository auditLogRepository;
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void auditLogDetails(Order order, String action){
        AuditLog auditLog = new AuditLog();
        auditLog.setOrderId(Long.valueOf(order.getId()));
        auditLog.setAction(action);
        auditLog.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(auditLog);
    }
}
