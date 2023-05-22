package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.UserMenuSelect;
import com.groupd.bodymanager.entity.primaryKey.SelectPK;


@Repository
public interface UserMenuSelectRepository extends JpaRepository<UserMenuSelect,SelectPK>{
    public boolean existsByUserCode(int userCode);
    public UserMenuSelect findByUserCode(int userCode);
    
}
