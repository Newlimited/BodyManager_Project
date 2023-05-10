package com.groupd.bodymanager.dto.response.exerciseRoutine;

import com.groupd.bodymanager.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetExerciseRoutineResponseDto extends ResponseDto{
    private String routineImageUrl;

}
