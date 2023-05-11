package com.groupd.bodymanager.dto.request.dietRoutine;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchDietRoutineRequestDto {
    private String userCode;
    private String menuCode;


    
}
