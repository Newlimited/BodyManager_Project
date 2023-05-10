package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.groupd.bodymanager.dto.request.mileage.PostMileageRequestDto;

import lombok.Data;

@Data
@Table(name = "Mileage")
@Entity(name = "Mileage")
public class MileageEntity {

    public MileageEntity(PostMileageRequestDto dto) {
    }
    @Id
    private boolean attendanceResult;
    private int attendanceMileage;
    private String attendanceDate;

    
}
