package com.groupd.bodymanager.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.groupd.bodymanager.entity.BodyInfoEntity;

import org.springframework.stereotype.Repository;
@Repository
public interface BodyInfoRepository extends JpaRepository<BodyInfoEntity,Integer>{
    
    public boolean existsByUserCode(Integer userCode);
    public List<BodyInfoEntity> findByUserCode(Integer userCode);
   
    @Query(
        value = 
        "DELETE " +
        "FROM body_info WHERE user_code = ?; ",
        nativeQuery = true  
    )
    @Transactional
    @Modifying
    public Integer deleteUserBodyInfo(Integer userCode);
    
}
