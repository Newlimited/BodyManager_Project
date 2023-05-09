package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "BodyInfo")
@Entity(name = "BodyInfo")
public class BodyInfoEntity {
    private int userCode;
    private double height;
    private double weight;
    private double muscleMass;
    private double fateRate;
    private String recordDate;
    private double bmiIndex;
    private double bmiResult;

    
}
