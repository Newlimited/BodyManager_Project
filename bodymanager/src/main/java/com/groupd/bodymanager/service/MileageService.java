package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.mileage.PostMileageRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.mileage.GetMileageResponseDto;

public interface MileageService {
    public ResponseEntity<ResponseDto> postMileage(String userEmail, PostMileageRequestDto dto);

    public ResponseEntity<? super GetMileageResponseDto> getMileage(Integer userCode);
}
