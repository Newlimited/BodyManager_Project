package com.groupd.bodymanager.dto.request.dietRoutine;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDietRoutineRequestDto {
    private int userCode;
    private String menuCode;
    private String menuName;

}
