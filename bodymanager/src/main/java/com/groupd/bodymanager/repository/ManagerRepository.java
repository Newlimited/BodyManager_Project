package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.ManagerEntity;
import org.springframework.stereotype.Repository;
@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity , String>{
    
    public boolean existsByManagerEmail(String email);
    public ManagerEntity findByManagerEmail(String email);
}
