package com.groupd.bodymanager.dto.request.menu;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuRequestDto {
    
    @NotNull
    private Integer userCode;
    @NotBlank
    private String menuCode;


}
