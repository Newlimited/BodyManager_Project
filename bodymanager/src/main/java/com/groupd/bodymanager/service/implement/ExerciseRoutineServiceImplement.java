package com.groupd.bodymanager.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.exerciseRoutine.GetExerciseRoutineResponseDto;
import com.groupd.bodymanager.entity.ExerciseRoutineEntity;
import com.groupd.bodymanager.repository.ExerciseRoutineRepository;
import com.groupd.bodymanager.service.ExerciseRoutineService;

@Service
public class ExerciseRoutineServiceImplement implements ExerciseRoutineService {
    
    private ExerciseRoutineRepository exerciseRoutineRepository;

    @Autowired
    public ExerciseRoutineServiceImplement(ExerciseRoutineRepository exerciseRoutineRepository){
        this.exerciseRoutineRepository = exerciseRoutineRepository;
    }

    @Override
    public ResponseEntity<? super GetExerciseRoutineResponseDto> getRoutin(Integer routineNumber) {
            
            GetExerciseRoutineResponseDto body = null;

        try {

            if (routineNumber == null) {
                return CustomResponse.validationFaild();
            }

            //존재하지 않는 루틴 번호 반환
            ExerciseRoutineEntity exerciseRoutineEntity = exerciseRoutineRepository.findByRoutinNumber(routineNumber);
            if(exerciseRoutineEntity == null) return CustomResponse.notExistRoutineNumber();

            //이미지 가져오기
            String routineImageUrl = exerciseRoutineEntity.getRoutineImageUrl();

            body = new GetExerciseRoutineResponseDto(exerciseRoutineEntity);
            body.setRoutineImageUrl(routineImageUrl);

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto errorbody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorbody);
        }

        return CustomResponse.successs();
    }

    
}
