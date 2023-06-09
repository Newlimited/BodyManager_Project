package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.bodyInfo.PostBodyInfoRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.bodyInfo.GetBodyInfoResponseDto;

public interface BodyInfoService {
    public ResponseEntity<ResponseDto> postBodyInfo(String email, PostBodyInfoRequestDto dto);

    public ResponseEntity<? super GetBodyInfoResponseDto> getBodyInfo(Integer userCode);
}
