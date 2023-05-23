package com.groupd.bodymanager.dto.response.menu;

import com.groupd.bodymanager.dto.response.ResponseDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchMenuResponseDto extends ResponseDto {


    private int userCode;
    private String menuCode;

    public PatchMenuResponseDto(int userCode, String menuCode) {
        super("SU", "Success");
        this.userCode = userCode;
        this.menuCode = menuCode;
    }
    
    
}
