package com.groupd.bodymanager.repository;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.groupd.bodymanager.entity.MenuDetailEntity;
import com.groupd.bodymanager.entity.resultSet.MenuListResultSet;

import org.springframework.stereotype.Repository;

@Repository
public interface MenuDetailRepository extends JpaRepository<MenuDetailEntity,Integer>{

    public MenuDetailEntity findByMenuCode(String menuCode);

    @Query(value = 
        "select" 
        +"MD.menu_code AS menuCode,"
        +"MD.time,"
        +"MD.monday,"
        +"MD.tuesday,"
        +"MD.wednesday,"
        +"MD.thursday,"
        +"MD.friday,"
        +"MD.saturday,"
        +"MD.sunday"
        +"from menu M, menu_detail MD, usermenuselect US, user U"
        +"where MD.menu_code = M.menu_code "
        +"and M.menu_code = US.menu_code "
        +"and US.user_code = U.user_code"
        +"order by MD.menu_index;",
        nativeQuery = true
    )
    public List<MenuListResultSet> getMenuDetailList();

}