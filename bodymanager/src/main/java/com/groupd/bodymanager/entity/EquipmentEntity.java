package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Equipment")
@Table(name="Equipment")
public class EquipmentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipmentNumber;
    private String equipmentName;
    private String equipmentUsage;
    private String equipmentImageUrl;

    public EquipmentEntity(EquipmentEntity equipmentEntity){
        this.equipmentNumber = equipmentEntity.getEquipmentNumber();
        this.equipmentName = equipmentEntity.getEquipmentName();
        this.equipmentUsage = equipmentEntity.getEquipmentUsage();
        this.equipmentImageUrl = equipmentEntity.getEquipmentImageUrl();
    }
}
