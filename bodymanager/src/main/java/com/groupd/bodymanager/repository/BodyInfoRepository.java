package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.BodyInfoEntity;

public interface BodyInfoRepository extends JpaRepository<BodyInfoEntity,Integer>{
    
    
}
