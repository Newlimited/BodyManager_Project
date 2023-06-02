package com.groupd.bodymanager.service;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;


import com.groupd.bodymanager.dto.request.user.DeleteUserRequestDto;
import com.groupd.bodymanager.dto.request.user.PatchUserRequestDto;

import com.groupd.bodymanager.dto.request.user.SignInRequestDto;
import com.groupd.bodymanager.dto.request.user.SignUpRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.user.GetAuthResponseDto;
import com.groupd.bodymanager.dto.response.user.GetUserResponseDto;

public interface UserService {
    
    public ResponseEntity<? super GetAuthResponseDto> signIn(SignInRequestDto dto);
    public ResponseEntity<? super GetAuthResponseDto> signUp(SignUpRequestDto dto);
    public ResponseEntity<? super GetAuthResponseDto> logout(String email, HttpSession httpSession);
    public ResponseEntity<? super GetUserResponseDto> getUser(Integer userCode);
    
    public ResponseEntity<ResponseDto> patchUser(String email, PatchUserRequestDto dto);
    public ResponseEntity<ResponseDto> deleteUser(String userEmail, DeleteUserRequestDto dto);
}
