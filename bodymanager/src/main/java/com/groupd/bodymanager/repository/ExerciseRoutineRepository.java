package com.groupd.bodymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.ExerciseRoutineEntity;
@Repository
public interface ExerciseRoutineRepository extends JpaRepository<ExerciseRoutineEntity, Integer>{
    
    public ExerciseRoutineEntity findByRoutinNumber(int routineNumber);
}
