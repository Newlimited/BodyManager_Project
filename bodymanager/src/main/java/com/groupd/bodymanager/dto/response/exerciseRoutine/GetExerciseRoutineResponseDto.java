package com.groupd.bodymanager.dto.response.exerciseRoutine;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.ExerciseRoutineEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetExerciseRoutineResponseDto extends ResponseDto{
    
    
    private String routineImageUrl1;
    private String routineImageUrl2;
    private String routineImageUrl3;

    public GetExerciseRoutineResponseDto(ExerciseRoutineEntity exerciseRoutineEntity){
        super("SU","Success");
        this.routineImageUrl1 = exerciseRoutineEntity.getRoutineImageUrl1();
        this.routineImageUrl2 = exerciseRoutineEntity.getRoutineImageUrl2();
        this.routineImageUrl3 = exerciseRoutineEntity.getRoutineImageUrl3();
    }
}
