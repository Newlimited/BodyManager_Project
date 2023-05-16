package com.groupd.bodymanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.MenuDetailEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDetailRepository extends JpaRepository<MenuDetailEntity,Integer>{
    
}
