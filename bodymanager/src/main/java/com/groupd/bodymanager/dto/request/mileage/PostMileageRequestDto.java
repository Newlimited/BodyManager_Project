package com.groupd.bodymanager.dto.request.mileage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostMileageRequestDto {
    private String userCode;
    private boolean attendanceResult;
    private int attendanceMileage;
    private String date;
}
