package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.menu.PatchMenuRequestDto;
import com.groupd.bodymanager.dto.request.menu.PostMenuRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuResponseDto;

public interface MenuService {
    public ResponseEntity<ResponseDto> postDietRoutine(PostMenuRequestDto dto);
    public ResponseEntity<ResponseDto> patchDietRoutine(PatchMenuRequestDto dto);
    public ResponseEntity<? super GetMenuResponseDto> getDietRoutine(PostMenuRequestDto dto);
}
