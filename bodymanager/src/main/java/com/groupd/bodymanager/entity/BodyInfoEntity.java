package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.groupd.bodymanager.dto.request.bodyInfo.PostBodyInfoRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BodyInfo")
@Entity(name = "BodyInfo")
public class BodyInfoEntity {

    @Id
    private int userCode;
    private double height;
    private double weight;
    private double muscleMass;
    private double fateRate;
    private String recordDate;
    private double bmiIndex;
    private String bmiResult;

    public BodyInfoEntity(PostBodyInfoRequestDto dto) {
        this.height = dto.getHeight();
        this.weight = dto.getWeight();
        this.muscleMass = dto.getMuscleMass();

        
    }

    
}
