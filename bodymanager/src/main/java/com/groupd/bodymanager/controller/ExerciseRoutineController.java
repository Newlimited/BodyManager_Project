package com.groupd.bodymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupd.bodymanager.dto.response.exerciseRoutine.GetExerciseRoutineResponseDto;
import com.groupd.bodymanager.service.ExerciseRoutineService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/exercise-routine")
@RequiredArgsConstructor
public class ExerciseRoutineController {
    
    @Autowired
    private final ExerciseRoutineService exerciseRoutineService;

    @GetMapping("/{routineNumber}")
    public ResponseEntity<? super GetExerciseRoutineResponseDto> getExerciseRoutine(
            @PathVariable("routineNumber") Integer routineNumber
        ) {
        ResponseEntity<? super GetExerciseRoutineResponseDto> response = exerciseRoutineService.getRoutin(routineNumber);
        return response;
    }
}