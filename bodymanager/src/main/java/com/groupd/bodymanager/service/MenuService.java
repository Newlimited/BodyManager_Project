package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.menu.PatchMenuRequestDto;
import com.groupd.bodymanager.dto.request.menu.PostMenuRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuDetailListResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuDetailListResponseDto;

public interface MenuService {
  
    public ResponseEntity<ResponseDto> patchDietRoutine(PatchMenuRequestDto dto);
<<<<<<< HEAD
    public ResponseEntity<? super GetMenuResponseDto> getMenuDetail(PostMenuRequestDto dto);
    public ResponseEntity<? super GetMenuDetailListResponseDto> postDietRoutine(PostMenuRequestDto dto);
=======
    public ResponseEntity<? super GetMenuResponseDto> getDietRoutine(PostMenuRequestDto dto);
    public ResponseEntity<? super GetMenuDetailListResponseDto> getMenuDetailList();

>>>>>>> 0cd8678ce329d252ecbfbebf662855bbc34a9417
}
