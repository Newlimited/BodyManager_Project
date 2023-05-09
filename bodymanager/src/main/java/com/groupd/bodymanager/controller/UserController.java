package com.groupd.bodymanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupd.bodymanager.dto.request.user.PatchUserRequestDto;
import com.groupd.bodymanager.dto.request.user.SignInRequestDto;
import com.groupd.bodymanager.dto.request.user.SignUpRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.user.GetAuthResponseDto;
import com.groupd.bodymanager.dto.response.user.GetUserResponseDto;
import com.groupd.bodymanager.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController{
    
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("sign-up")
    public ResponseEntity<? super GetAuthResponseDto> signUp(
        @Valid @RequestBody SignUpRequestDto requestBody
    ){
        ResponseEntity<? super GetAuthResponseDto> response = userService.signUp(requestBody);
        return response;
    }

    @PostMapping("sign-in")
    public ResponseEntity<? super GetAuthResponseDto> signIn(
        @Valid @RequestBody SignInRequestDto requsetBody
    ){
        ResponseEntity<? super GetAuthResponseDto> response = userService.signIn(requsetBody);
        return response;
    }

    @GetMapping("/{userCode}")
    public ResponseEntity<? super GetUserResponseDto> getUser(
        @PathVariable("userCode") Integer userCode
    ){
        ResponseEntity<? super GetUserResponseDto> response =
            userService.getUser(userCode);
        return response;
    }

    @PatchMapping("")
    public ResponseEntity<ResponseDto> patchUser(
        @Valid @RequestBody PatchUserRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response =
            userService.patchUser(requestBody);
        return response;
    }

    @DeleteMapping("/{userEmail}/{userCode}")
    public ResponseEntity<ResponseDto> deleteUser(
        @PathVariable("userEmail") String userEmail,
        @PathVariable("userCode") Integer userCode
    ){
        ResponseEntity<ResponseDto> response =
            userService.deletdUser(userEmail, userCode);
        return response;
    }

} 