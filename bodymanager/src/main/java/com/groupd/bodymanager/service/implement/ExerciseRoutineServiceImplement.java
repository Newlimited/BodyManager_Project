package com.groupd.bodymanager.service.implement;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.exerciseRoutine.GetExerciseRoutineResponseDto;
import com.groupd.bodymanager.entity.ExerciseRoutineEntity;
import com.groupd.bodymanager.repository.ExerciseRoutineRepository;
import com.groupd.bodymanager.service.ExerciseRoutineService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExerciseRoutineServiceImplement implements ExerciseRoutineService {
    private final ExerciseRoutineRepository exerciseRoutineRepository;

    @Override
    public ResponseEntity<? super GetExerciseRoutineResponseDto> getRoutin(Integer routineNumber) {
        GetExerciseRoutineResponseDto body = null;
        try {

            if (routineNumber == null) {
                return CustomResponse.validationFaild();
            }

            // 존재하지 않는 루틴 번호 반환
            ExerciseRoutineEntity exerciseRoutineEntity = exerciseRoutineRepository.findByRoutineNumber(routineNumber);
            if (exerciseRoutineEntity == null)
                return CustomResponse.notExistRoutineNumber();
            // 이미지 가져오기
            String routineImageUrl1 = exerciseRoutineEntity.getRoutineImageUrl1();
            String routineImageUrl2 = exerciseRoutineEntity.getRoutineImageUrl2();
            String routineImageUrl3 = exerciseRoutineEntity.getRoutineImageUrl3();

           //이미지 저장하기 
            exerciseRoutineEntity.setRoutineImageUrl1(routineImageUrl1);
            exerciseRoutineEntity.setRoutineImageUrl2(routineImageUrl2);
            exerciseRoutineEntity.setRoutineImageUrl3(routineImageUrl3);
            exerciseRoutineRepository.save(exerciseRoutineEntity);
            body = new GetExerciseRoutineResponseDto(exerciseRoutineEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto errorbody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorbody);
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
