package com.groupd.bodymanager.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.MileageEntity;


@Repository
public interface MileageRepository extends JpaRepository<MileageEntity,Integer>{
   
    public MileageEntity findByAttendanceDate(Date attendanceDate);
    public boolean AttendanceToday(boolean attendanceToday);
    public MileageEntity findByUserCodeAndAttendanceToday(int userCode,boolean attendanceToday);
    public MileageEntity findByUserCode(int userCode);
}