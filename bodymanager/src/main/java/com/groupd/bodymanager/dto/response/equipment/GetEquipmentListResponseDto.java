package com.groupd.bodymanager.dto.response.equipment;

import java.util.ArrayList;
import java.util.List;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.EquipmentEntity;
import com.groupd.bodymanager.entity.resultSet.EquipmentListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetEquipmentListResponseDto extends ResponseDto{
    
    private List<EquipmentSummary> equipmentList;

    public GetEquipmentListResponseDto(List<EquipmentListResultSet> resultSet){
        super("SU","Success");

        List<EquipmentSummary> equipmentList = new ArrayList<>();
        for(EquipmentListResultSet result : resultSet) {
            EquipmentSummary equipmentSummary = new EquipmentSummary(result);
            equipmentList.add(equipmentSummary);
        }
        this.equipmentList = equipmentList;

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class EquipmentSummary{

    private Integer equipmentNumber;
    private String equipmentName;
    private String equipmentUsage;
    private String equipmentImageUrl;

    public EquipmentSummary(EquipmentListResultSet resultSet){
        this.equipmentNumber = resultSet.getEquipmentNumber();
        this.equipmentName = resultSet.getEquipmentName();
        this.equipmentUsage = resultSet.getEquipmentUsage();
        this.equipmentImageUrl = resultSet.getEquipmentImageUrl();
    }

    public EquipmentSummary(EquipmentEntity equipmentEntity){
        this.equipmentNumber = equipmentEntity.getEquipmentNumber();
        this.equipmentName = equipmentEntity.getEquipmentName();
        this.equipmentUsage = equipmentEntity.getEquipmentUsage();
        this.equipmentImageUrl =equipmentEntity.getEquipmentImageUrl();
    }
}
