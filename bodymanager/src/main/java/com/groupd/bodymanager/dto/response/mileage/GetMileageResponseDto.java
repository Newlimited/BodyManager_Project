package com.groupd.bodymanager.dto.response.mileage;

import java.util.Date;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.MileageEntity;
import com.groupd.bodymanager.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMileageResponseDto extends ResponseDto{
    private int userCode;
    private boolean attendanceResult;
    private int attendanceMileage;
    private Date attendanceDate;

    public GetMileageResponseDto(MileageEntity mileageEntity){
        super("SU", "Success");
         //test/
    }
}

