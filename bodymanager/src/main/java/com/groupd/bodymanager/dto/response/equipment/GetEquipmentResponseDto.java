package com.groupd.bodymanager.dto.response.equipment;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.EquipmentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEquipmentResponseDto extends ResponseDto{
    private int equipmentNumber;
    private String equipmentName;
    private String equipmentUsage;
    private String equipmentImageUrl;

    public GetEquipmentResponseDto(EquipmentEntity equipmentEntity){
        super("SU", "Sucess");
        this.equipmentNumber = equipmentEntity.getEquipmentNumber();
        this.equipmentName = equipmentEntity.getEquipmentName();
        this.equipmentUsage = equipmentEntity.getEquipmentUsage();
        this.equipmentImageUrl = equipmentEntity.getEquipmentImageUrl();
    }
}
