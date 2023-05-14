package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.bodyInfo.PostBodyInfoRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;

public interface BodyInfoService {
    public ResponseEntity<ResponseDto> postBodyInfo(PostBodyInfoRequestDto dto);
}
