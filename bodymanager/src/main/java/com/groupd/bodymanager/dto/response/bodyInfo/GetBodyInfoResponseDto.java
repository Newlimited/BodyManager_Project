package com.groupd.bodymanager.dto.response.bodyInfo;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.BodyInfoEntity;
import com.groupd.bodymanager.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBodyInfoResponseDto extends ResponseDto{
    private int userCode;
    private String userEmail;
    private double height;
    private double weight;
    private double muscleMass;
    private double fatRate;
    private String recordDate;
    private double bmiIndex;
    private String bmiResult;

    public GetBodyInfoResponseDto(BodyInfoEntity bodyInfoEntity,UserEntity userEntity) {
        super("SU", "Success");

        this.userCode = bodyInfoEntity.getUserCode();
        this.userEmail = userEntity.getUserEmail();
        this.height = bodyInfoEntity.getHeight();
        this.weight = bodyInfoEntity.getWeight();
        this.muscleMass = bodyInfoEntity.getMuscleMass();
        this.fatRate = bodyInfoEntity.getFatRate();
        this.recordDate = bodyInfoEntity.getRecordDate();
        this.bmiIndex = bodyInfoEntity.getBmiIndex();
        this.bmiResult = bodyInfoEntity.getBmiResult();

    }


    
}  
