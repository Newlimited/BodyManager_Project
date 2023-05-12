package com.groupd.bodymanager.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
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
    private  UserRepository userRepository;
    private  MileageRepository mileageRepository;

    @Override
    public ResponseEntity<ResponseDto> postMileage(PostMileageRequestDto dto) {

        ResponseDto body = null;

        int userCode = dto.getUserCode();
        
        try {
            // 존재하지 않는 유저코드 반환
            UserEntity existeduserCode = userRepository.findByUserCode(userCode);
            if(existeduserCode == null) {
                ResponseDto errorBody = new ResponseDto("NC", "Non-Existent User Code");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }

            // 출석체크를 하루에 한번만 할 수 있게 해야함.

            // 마일리지 + 10
            MileageEntity mileageEntity = new MileageEntity(dto);
            int attendanceMileage = mileageEntity.getAttendanceMileage();
            mileageEntity.setAttendanceMileage(attendanceMileage +10);
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
            

        } catch (Exception exception) {
            // 데이터베이스 오류 반환 //
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }




}
