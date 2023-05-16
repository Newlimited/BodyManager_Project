package com.groupd.bodymanager.dto.request.menu;


import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostMenuRequestDto {
    
    @NotBlank
    private int userCode;
    @NotBlank
    private String menuCode;
  
 

}
