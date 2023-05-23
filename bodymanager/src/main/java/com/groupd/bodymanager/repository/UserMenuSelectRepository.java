package com.groupd.bodymanager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.UserMenuSelect;
import com.groupd.bodymanager.entity.primaryKey.SelectPK;


@Repository
public interface UserMenuSelectRepository extends JpaRepository<UserMenuSelect,SelectPK>{
    public boolean existsByUserCode(int userCode);
    public UserMenuSelect findByUserCode(int userCode);

    @Query(
        value=
        "UPDATE "+
        "user_menu_select "+
        "SET menu_code = ? WHERE user_code = ?; ",
        nativeQuery = true)
    @Modifying
    @Transactional
    public int patchMenuCode(String menuCode, Integer userCode);
    
}
