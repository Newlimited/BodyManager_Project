package com.groupd.bodymanager.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.repository.ExerciseRoutineRepository;

@Service
public class ExerciseRoutineServiceImplement {
    
    @Autowired
    ExerciseRoutineRepository exerciseRoutineRepository;

    
}
