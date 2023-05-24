package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.menu.MenuPostRequestDto;
import com.groupd.bodymanager.dto.request.menu.MenuRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuDetailListResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetUserMenuResponseDto;;

public interface MenuService {

    public ResponseEntity<ResponseDto> postMenuCodeAndUserCode(String email, MenuRequestDto dto);
    public ResponseEntity<? super GetMenuDetailListResponseDto> getMenuList();
    public ResponseEntity<? super GetUserMenuResponseDto> getMenu(Integer userCode);
    public ResponseEntity<ResponseDto> patchMenuCode(String email, MenuRequestDto dto);

}
