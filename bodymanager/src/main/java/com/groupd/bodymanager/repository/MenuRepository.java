package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.groupd.bodymanager.entity.MenuEntity;
import org.springframework.stereotype.Repository;
@Repository

public interface MenuRepository extends JpaRepository<MenuEntity,String>{
    
}
