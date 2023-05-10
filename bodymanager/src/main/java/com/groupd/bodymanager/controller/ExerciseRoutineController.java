package com.groupd.bodymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupd.bodymanager.dto.response.exerciseRoutine.GetExerciseRoutineResponseDto;
import com.groupd.bodymanager.service.ExerciseRoutineService;

@RestController
public class ExerciseRoutineController {
    
    @Autowired
    ExerciseRoutineService exerciseRoutineService;

    @GetMapping("/exercise-routine")
    public GetExerciseRoutineResponseDto getExerciseRoutine(String routinNumber) {
        
        return null;
    }
}