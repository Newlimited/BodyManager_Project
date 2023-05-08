package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.BoardEntity;


public interface BoardRepository extends JpaRepository<BoardEntity, String>{
    
}
