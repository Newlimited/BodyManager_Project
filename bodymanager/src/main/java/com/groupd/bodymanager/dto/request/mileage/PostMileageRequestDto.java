package com.groupd.bodymanager.dto.request.mileage;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostMileageRequestDto {

    @NotBlank
    private int userCode;
    @NotBlank
    private boolean attendanceResult;
    @NotBlank
    private int attendanceMileage;
    @NotBlank
    private Date attendance;
}
