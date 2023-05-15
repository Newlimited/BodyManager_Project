package com.groupd.bodymanager.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupd.bodymanager.dto.request.bodyInfo.PatchBodyInfoRequestDto;
import com.groupd.bodymanager.dto.request.bodyInfo.PostBodyInfoRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.bodyInfo.GetBodyInfoResponseDto;
import com.groupd.bodymanager.service.BodyInfoService;

@RestController
@RequestMapping("api/v1/body-info")
public class BodyInfoController {

    private BodyInfoService bodyInfoService;

    public BodyInfoController(BodyInfoService bodyInfoService){
        this.bodyInfoService = bodyInfoService;
    }

    // 1.신체 정보 등록
    @PostMapping("")
    public ResponseEntity<ResponseDto> postBodyInfo(
        @Valid @RequestBody PostBodyInfoRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = bodyInfoService.postBodyInfo(requestBody);
        return response;
    }
    // 2.신체 정보 조회
    @GetMapping("/{userCode}")
    public ResponseEntity<? super GetBodyInfoResponseDto> getBodyInfo(
        @PathVariable("userCode") Integer userCode
    ){
        ResponseEntity<? super GetBodyInfoResponseDto> response =
            bodyInfoService.getBodyInfo(userCode);
            return response;
    }

    // 3.신체 정보 수정
    @PatchMapping("")
    public ResponseEntity<ResponseDto> patchBodyInfo(
        @Valid @RequestBody PatchBodyInfoRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = bodyInfoService.patchBodyInfo(requestBody);
        return response;
    }
}
