package com.groupd.bodymanager.service.implement;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.mileage.PostMileageRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.mileage.GetMileageResponseDto;
import com.groupd.bodymanager.entity.MileageEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.repository.MileageRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.MileageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MileageServiceImplement implements MileageService {
    private  final UserRepository userRepository;
    private  final MileageRepository mileageRepository;

    @Override
    public ResponseEntity<ResponseDto> postMileage(String userEmail, PostMileageRequestDto dto) {

        ResponseDto body = null;
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String attendanceDate = simpleDateFormat.format(now);
        
        Integer userCode = dto.getUserCode();
        
        try {
         
            
            // 존재하지 않는 유저코드 반환
            UserEntity existeduserCode = userRepository.findByUserCode(userCode);
            if (existeduserCode == null) {
                return CustomResponse.notExistUserCode();
            }
            // 권한없음
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            Integer logInUserCode = userEntity.getUserCode();
            boolean isMatchUserCode = logInUserCode.equals(userCode);
            
            if(!isMatchUserCode){
                return CustomResponse.noPermission();
            }
            MileageEntity mileageEntity = mileageRepository.findByUserCode(userCode);
            String attendanceStatusToday = mileageEntity.getAttendanceDate();
            boolean isNull = attendanceStatusToday == null;
            if (!isNull) {
                boolean isOtherDay = attendanceStatusToday.equals(attendanceDate);
                if (!isOtherDay) {
                    mileageEntity.setAttendanceToday(false);
                    mileageRepository.save(mileageEntity);
                }
            }

            // 이미 출석했는지 확인
            // boolean attendanceResult = dto.isAttendanceResult();
            MileageEntity attendanceStatus = mileageRepository.findByUserCodeAndAttendanceToday(userCode, true);
            if(attendanceStatus != null){
                return CustomResponse.alreadyAtteneded();
            
        }
                        
            // 출석 및 마일리지 +10
            mileageEntity.setAttendanceToday(true);
            mileageEntity.setAttendanceDate(attendanceDate);
            mileageEntity.setAttendanceMileage(mileageEntity.getAttendanceMileage() + 10);
            mileageRepository.save(mileageEntity);

            body = new ResponseDto("SU", "Success");
            
        } catch (Exception exception) {
            // 데이터베이스 오류 반환 //
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }
        
        // 성공반환
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetMileageResponseDto> getMileage(Integer userCode) {
        
        GetMileageResponseDto body = null;
        
        try {

            if(userCode == null) return CustomResponse.validationFaild();
            
            // 존재하지 않는 유저코드 반환
            UserEntity existeduserCode = userRepository.findByUserCode(userCode);
            if(existeduserCode == null) {
            ResponseDto errorBody = new ResponseDto("NC", "Non-Existent User Code");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }       
            
            MileageEntity mileageEntity = mileageRepository.findByUserCode(userCode);
            
            Integer totalMileage = mileageEntity.getAttendanceMileage();
            body = new GetMileageResponseDto(userCode, totalMileage);
        } catch (Exception exception) {
            // 데이터베이스 오류 반환 //
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }




}
