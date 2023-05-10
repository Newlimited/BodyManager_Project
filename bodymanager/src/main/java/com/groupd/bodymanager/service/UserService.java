package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.dto.request.user.PatchUserRequestDto;
import com.groupd.bodymanager.dto.request.user.PostManagerRequestDto;
import com.groupd.bodymanager.dto.request.user.SignInRequestDto;
import com.groupd.bodymanager.dto.request.user.SignUpRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.user.GetAuthResponseDto;
import com.groupd.bodymanager.dto.response.user.GetUserResponseDto;

public interface UserService {
    
    public ResponseEntity<? super GetAuthResponseDto> signIn(SignInRequestDto dto);
    public ResponseEntity<? super GetAuthResponseDto> signUp(SignUpRequestDto dto);
    public ResponseEntity<? super GetUserResponseDto> getUser(Integer userCode);
    public ResponseEntity<? super GetUserResponseDto> addManager(PostManagerRequestDto dto);
    public ResponseEntity<ResponseDto> patchUser(PatchUserRequestDto dto);
    public ResponseEntity<ResponseDto> deletdUser(String userEmail, Integer userCode);
}
