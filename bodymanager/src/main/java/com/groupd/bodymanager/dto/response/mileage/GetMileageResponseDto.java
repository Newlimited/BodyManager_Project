package com.groupd.bodymanager.dto.response.mileage;


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
    private int attendanceMileage;


    public GetMileageResponseDto(UserEntity userEntity,MileageEntity mileageEntity){
        super("SU", "Success");
        this.userCode = userEntity.getUserCode();
        this.attendanceMileage = mileageEntity.getAttendanceMileage();
        
    
    }

}

