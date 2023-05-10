package com.groupd.bodymanager.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.mileage.PostMileageRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.MileageEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.repository.MileageRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.MileageService;

@Service
public class MileageServiceImplement implements MileageService {
    private UserRepository userRepository;
    private MileageRepository mileageRepository;

    @Autowired
    public MileageServiceImplement(MileageRepository mileageRepository, UserRepository userRepository){
        this.mileageRepository = mileageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> postMileage(PostMileageRequestDto dto) {

        ResponseDto body = null;

        int userCode = dto.getUserCode();
        
        try {
            // 존재하지 않는 유저코드 반환
            UserEntity existeduserCode = userRepository.findByUserCode(userCode);
            if(existeduserCode == null) {
                ResponseDto errorBody = new ResponseDto("NU", "Non-Existent User Code");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }

            MileageEntity mileageEntity = new MileageEntity(dto);
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



}
