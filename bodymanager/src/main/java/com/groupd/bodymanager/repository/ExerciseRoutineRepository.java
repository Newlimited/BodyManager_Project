package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.ExerciseRoutineEntity;

public interface ExerciseRoutineRepository extends JpaRepository<ExerciseRoutineEntity, Integer>{
    
}
