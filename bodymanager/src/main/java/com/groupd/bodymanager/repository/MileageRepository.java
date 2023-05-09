package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.MileageEntity;

public interface MileageRepository extends JpaRepository<MileageEntity,Integer>{
    
}
