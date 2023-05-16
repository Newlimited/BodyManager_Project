package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.menu.PatchMenuRequestDto;
import com.groupd.bodymanager.dto.request.menu.PostMenuRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuDetailListResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuDetailListResponseDto;

public interface MenuService {
<<<<<<< HEAD
  
    public ResponseEntity<ResponseDto> postDietRoutine(PostMenuRequestDto dto);
=======
    
    public ResponseEntity<? super GetMenuDetailListResponseDto> postDietRoutine(PostMenuRequestDto dto);
>>>>>>> 9953ebc5ea8f3bb479055cb4e54ae371bafd73e6
    public ResponseEntity<ResponseDto> patchDietRoutine(PatchMenuRequestDto dto);
    public ResponseEntity<? super GetMenuResponseDto> getDietRoutine(PostMenuRequestDto dto);
    public ResponseEntity<? super GetMenuDetailListResponseDto> getMenuDetailList();

}
