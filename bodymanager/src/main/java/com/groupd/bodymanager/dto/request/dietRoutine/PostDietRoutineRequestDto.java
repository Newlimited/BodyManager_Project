package com.groupd.bodymanager.dto.request.dietRoutine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDietRoutineRequestDto {
    private String userCode;
    private String menuCode;
}
