package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.UserMenuSelect;
import com.groupd.bodymanager.entity.primaryKey.selectPK;



public interface UserMenuSelectRepository extends JpaRepository<UserMenuSelect,selectPK>{
    public UserMenuSelect findByUserCode(int userCode);
    
}
