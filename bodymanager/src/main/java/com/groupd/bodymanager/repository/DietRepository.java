package com.groupd.bodymanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.DietEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface DietRepository extends JpaRepository<DietEntity,Integer>{

    DietEntity findByMenuCodeAndOUserCode(String menuCode, int userCode);
}
