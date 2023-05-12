package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.MileageEntity;
import com.groupd.bodymanager.entity.UserEntity;

@Repository
public interface MileageRepository extends JpaRepository<MileageEntity,Integer>{
    public UserEntity findByUserCode(int userCode);
}
