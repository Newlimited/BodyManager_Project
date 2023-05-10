package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.ManagerEntity;

public interface ManagerRepository extends JpaRepository<ManagerEntity , String>{
    
    public boolean existsByEmail(String email);
    
}
