package com.groupd.bodymanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.BodyInfoEntity;

import org.springframework.stereotype.Repository;
@Repository
public interface BodyInfoRepository extends JpaRepository<BodyInfoEntity,Integer>{
    public List<BodyInfoEntity> findByUserCode(int userCode);
    public boolean existsByUserCode(int userCode);
    
}
