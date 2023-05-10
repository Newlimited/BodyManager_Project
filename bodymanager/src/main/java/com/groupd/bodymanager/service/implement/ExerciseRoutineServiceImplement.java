package com.groupd.bodymanager.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.dto.response.exerciseRoutine.GetExerciseRoutineResponseDto;
import com.groupd.bodymanager.repository.ExerciseRoutineRepository;
import com.groupd.bodymanager.service.ExerciseRoutineService;

@Service
public class ExerciseRoutineServiceImplement implements ExerciseRoutineService {
    
    @Autowired
    ExerciseRoutineRepository exerciseRoutineRepository;

    @Override
    public ResponseEntity<GetExerciseRoutineResponseDto> getRoutin(Integer routinNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoutin'");
    }

    
}
