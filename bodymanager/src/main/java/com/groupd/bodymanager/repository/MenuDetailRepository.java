package com.groupd.bodymanager.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.groupd.bodymanager.entity.MenuDetailEntity;
import com.groupd.bodymanager.entity.resultSet.MenuListResultSet;

import org.springframework.stereotype.Repository;

@Repository
public interface MenuDetailRepository extends JpaRepository<MenuDetailEntity,Integer>{

    public MenuDetailEntity findByMenuCode(String menuCode);

    @Query(
        value = 
        "SELECT " +
        "* FROM user_select_menu ",
        nativeQuery = true
    )
        public List<MenuDetailEntity> getMenuDetail(String menuCode);

    @Query(value =
        "SELECT "
        +"MD.menu_code AS menuCode, "
        +"MD.time As time, "
        +"MD.monday AS monday, "
        +"MD.tuesday AS tuesday, "
        +"MD.wednesday AS wednesday, "
        +"MD.thursday AS thursday, "
        +"MD.friday AS friday, "
        +"MD.saturday AS saturday, "
        +"MD.sunday AS sunday "
        +"from menu M, menu_detail MD "
        +"where MD.menu_code = M.menu_code "
        +"order by MD.menu_index; ",
        nativeQuery = true
    )
    public List<MenuListResultSet> getMenuDetailList();



}