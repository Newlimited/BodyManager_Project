package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.dietRoutine.PatchDietRoutineRequestDto;
import com.groupd.bodymanager.dto.request.dietRoutine.PostDietRoutineRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.dietRoutine.GetDietRoutineResponseDto;

public interface DietRoutineService {
    public ResponseEntity<ResponseDto> postDietRoutine(PostDietRoutineRequestDto dto);
    public ResponseEntity<ResponseDto> patchDietRoutine(PatchDietRoutineRequestDto dto);
    public ResponseEntity<? super GetDietRoutineResponseDto> getDietRoutine(PostDietRoutineRequestDto dto);
}
