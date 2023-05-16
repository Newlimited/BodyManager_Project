package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.BodyInfoEntity;
import com.groupd.bodymanager.entity.UserEntity;

import org.springframework.stereotype.Repository;
@Repository
public interface BodyInfoRepository extends JpaRepository<BodyInfoEntity,Integer>{
    public BodyInfoEntity findByUserCode(int userCode);
    public boolean existsByUserCode(int userCode);
    
}
