package com.groupd.bodymanager.service;

import com.groupd.bodymanager.dto.response.user.GetTrainnerProfileResponse;
import org.springframework.http.ResponseEntity;
import com.groupd.bodymanager.dto.request.user.PostManagerRequestDto;
import com.groupd.bodymanager.dto.response.user.GetUserResponseDto;

public interface ManagerSerivce {
    public ResponseEntity<? super GetTrainnerProfileResponse> getTrainnerProfile();
    public ResponseEntity<? super GetUserResponseDto> addManager(PostManagerRequestDto dto);
}
