package com.groupd.bodymanager.service;


import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.response.exerciseRoutine.GetExerciseRoutineResponseDto;

public interface ExerciseRoutineService {
    public ResponseEntity<? super GetExerciseRoutineResponseDto> getRoutin(Integer routinNumber);
}
