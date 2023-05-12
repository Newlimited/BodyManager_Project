package com.groupd.bodymanager.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupd.bodymanager.dto.request.mileage.PostMileageRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.service.MileageService;

@RestController
@RequestMapping("/api/v1/mileage")
public class MileageController {
    
    private MileageService mileageService;

    public MileageController(MileageService mileageService){
        this.mileageService = mileageService;
    }

    // 출석체크 및 마일리지 등록
    @PostMapping("")
    public ResponseEntity<ResponseDto> postMileage(
        @Valid @RequestBody PostMileageRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = mileageService.postMileage(requestBody);
        return response;
    }

    
}
