package com.groupd.bodymanager.dto.response.bodyInfo;

import java.util.ArrayList;
import java.util.List;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.BodyInfoEntity;
import com.groupd.bodymanager.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBodyInfoResponseDto extends ResponseDto {
    private Integer userCode;
    private List<BodyInfoList> bodyInfoList;

    public GetBodyInfoResponseDto(List<BodyInfoEntity> bodyInfoEntities, UserEntity userEntity) {
        super("SU", "Success");

        this.userCode = userEntity.getUserCode();
        BodyInfoList bodyInfoList = new BodyInfoList();
        this.bodyInfoList = bodyInfoList.recordList(bodyInfoEntities);

    }
}
@Data
@NoArgsConstructor
class BodyInfoList {
    private String recordDate;
    private double height;
    private double weight;
    private double muscleMass;
    private double fatRate;
    private double bmiIndex;
    private String bmiResult;

    BodyInfoList(BodyInfoEntity bodyInfoEntity) {

        this.recordDate = bodyInfoEntity.getRecordDate();
        this.height = bodyInfoEntity.getHeight();
        this.weight = bodyInfoEntity.getWeight();
        this.muscleMass = bodyInfoEntity.getMuscleMass();
        this.fatRate = bodyInfoEntity.getFatRate();
        this.bmiIndex = bodyInfoEntity.getBmiIndex();
        this.bmiResult = bodyInfoEntity.getBmiResult();
    }
    static List<BodyInfoList> recordList(List<BodyInfoEntity> bodyInfoEntities){
        List<BodyInfoList> bodiInfoLists = new ArrayList<>();

    for (BodyInfoEntity bodyInfoEntity : bodyInfoEntities) {
        BodyInfoList bodyinfoList = new BodyInfoList(bodyInfoEntity);
        bodiInfoLists.add(bodyinfoList);
    }
    return bodiInfoLists;
}
}