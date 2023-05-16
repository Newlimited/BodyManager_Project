package com.groupd.bodymanager.dto.request.menu;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchMenuRequestDto {
    private String userCode;
    private String menuCode;


    
}
