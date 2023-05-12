package com.groupd.bodymanager.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.groupd.bodymanager.dto.request.mileage.PostMileageRequestDto;

import lombok.Data;

@Data
@Table(name = "Mileage")
@Entity(name = "Mileage")
public class MileageEntity {

    @Id
    private int userCode;
    private boolean attendanceResult;
    private int attendanceMileage;
    private String attendanceDate;

    public MileageEntity(PostMileageRequestDto dto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
            new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String attendanceDate = simpleDateFormat.format(now);

        this.userCode = dto.getUserCode();
        this.attendanceResult = true;
        this.attendanceMileage = 0;
        this.attendanceDate = attendanceDate;
    }
}
