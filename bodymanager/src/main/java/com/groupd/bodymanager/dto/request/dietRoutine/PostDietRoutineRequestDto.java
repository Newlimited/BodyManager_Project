package com.groupd.bodymanager.dto.request.dietRoutine;


import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDietRoutineRequestDto {
   
    @NotBlank
    private String menuCode;
    @NotBlank
    private String menuName;

}
