package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BodyInfo")
@Entity(name = "BodyInfo")
public class BodyInfoEntity {
    
    private int userCode;
    @NotBlank
    private double height;
    @NotBlank
    private double weight;
    @NotBlank
    private double muscleMass;
    @NotBlank
    private double fateRate;
    @NotBlank
    private String recordDate;
    @NotBlank
    private double bmiIndex;
    @NotBlank
    private String bmiResult;

    
}
