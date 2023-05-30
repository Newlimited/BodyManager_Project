package com.groupd.bodymanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.groupd.bodymanager.entity.ManagerEntity;
import com.groupd.bodymanager.entity.resultSet.ManagerEmailResultSet;

import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity , String>{
    
    public boolean existsByManagerEmail(String email);
    public ManagerEntity findByManagerEmail(String email);

    @Query(
        value = 
        "SELECT manager_email AS managerEmail FROM Manager ",
        nativeQuery = true
    )
    public List<ManagerEmailResultSet> getMangerList();
}
