package com.groupd.bodymanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.groupd.bodymanager.dto.request.user.DeleteUserRequestDto;
import com.groupd.bodymanager.dto.request.user.PatchUserRequestDto;
import com.groupd.bodymanager.dto.request.user.PostManagerRequestDto;
import com.groupd.bodymanager.dto.request.user.SignInRequestDto;
import com.groupd.bodymanager.dto.request.user.SignUpRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.user.GetAuthResponseDto;
import com.groupd.bodymanager.dto.response.user.GetUserResponseDto;
import com.groupd.bodymanager.service.ManagerSerivce;
import com.groupd.bodymanager.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController{
    
    private final UserService userService;
    private final ManagerSerivce managerService;

    
    @PostMapping("add-manager")
    public ResponseEntity<? super GetUserResponseDto> addManager(
        @Valid @RequestBody PostManagerRequestDto requestBody
    ){
        ResponseEntity<? super GetUserResponseDto> response = managerService.addManager(requestBody);
        return response;
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

    @GetMapping("/logout")
    public ResponseEntity<? super GetAuthResponseDto> logout(
        @AuthenticationPrincipal String email, @Valid HttpSession httpSession) {
        ResponseEntity<? super GetAuthResponseDto> response = userService.logout(email, httpSession);
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
        @AuthenticationPrincipal String email,
        @Valid @RequestBody PatchUserRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response =
            userService.patchUser(email, requestBody);
        return response;
    }

    @PostMapping("quit")
    public ResponseEntity<ResponseDto> deleteUser(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody DeleteUserRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response =
            userService.deleteUser(email, requestBody);
        return response;
    }

} 