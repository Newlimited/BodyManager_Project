package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.DietEntity;

public interface DietRepository extends JpaRepository<DietEntity,Integer>{
    
}
