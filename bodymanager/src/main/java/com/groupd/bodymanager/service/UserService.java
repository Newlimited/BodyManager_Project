package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.groupd.bodymanager.dto.request.user.PatchUserRequestDto;
=======
>>>>>>> d83a2670bbe1c12246507be600697ad0b7f9d70e
import com.groupd.bodymanager.dto.request.user.SignInRequestDto;
import com.groupd.bodymanager.dto.request.user.SignUpRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.user.GetAuthResponseDto;
import com.groupd.bodymanager.dto.response.user.GetUserResponseDto;

public interface UserService {
    
    public ResponseEntity<? super GetAuthResponseDto> signIn(SignInRequestDto dto);
    public ResponseEntity<? super GetAuthResponseDto> signUp(SignUpRequestDto dto);
    public ResponseEntity<? super GetUserResponseDto> getUser(Integer userCode);
    public ResponseEntity<ResponseDto> patchUser(PatchUserRequestDto dto);
    public ResponseEntity<ResponseDto> deletdUser(String userEmail, Integer userCode);
}
