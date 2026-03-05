package com.example.transaction_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transaction_demo.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer>{
    
}
