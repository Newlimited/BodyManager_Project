package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.mileage.PostMileageRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;

public interface MileageService {
    public ResponseEntity<ResponseDto> postMileage(PostMileageRequestDto dto);
}
