package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.DietDetailEntity;
import org.springframework.stereotype.Repository;
@Repository
public interface DietDetailRepository extends JpaRepository<DietDetailEntity,Integer>{
    
}
