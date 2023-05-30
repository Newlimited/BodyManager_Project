package com.groupd.bodymanager.service;

import com.groupd.bodymanager.dto.response.user.GetTrainnerProfileResponse;
import org.springframework.http.ResponseEntity;

public interface TrainnerSerivce {
    public ResponseEntity<? super GetTrainnerProfileResponse> getTrainnerProfile();
    
}
