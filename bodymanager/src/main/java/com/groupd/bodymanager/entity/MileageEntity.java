package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "Mileage")
@Entity(name = "Mileage")
public class MileageEntity {

    private int attendanceResult;
    private int attendanceMileage;
    private String attendanceDate;

    
}
