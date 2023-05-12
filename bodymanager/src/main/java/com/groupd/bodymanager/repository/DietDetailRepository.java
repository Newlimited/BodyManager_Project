package com.groupd.bodymanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.DietDetailEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DietDetailRepository extends JpaRepository<DietDetailEntity,Integer>{

    DietDetailEntity findByDietNumber(int dietNumber);
    
}
