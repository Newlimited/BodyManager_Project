package com.groupd.bodymanager.controller;

import com.groupd.bodymanager.dto.response.user.GetTrainnerProfileResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupd.bodymanager.service.ManagerSerivce;
import com.groupd.bodymanager.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/trainner")
@RequiredArgsConstructor
public class ManagerProfileController {
    private final UserService userService; 
    private final ManagerSerivce trainnerSerivce;

    @GetMapping("")
    public ResponseEntity<? super GetTrainnerProfileResponse> getTrainnerProfile(
    ){
        ResponseEntity<? super GetTrainnerProfileResponse>  response =
            trainnerSerivce.getTrainnerProfile();
            return response;
    }
    
}
