package com.groupd.bodymanager.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.bodyInfo.PatchBodyInfoRequestDto;
import com.groupd.bodymanager.dto.request.bodyInfo.PostBodyInfoRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.bodyInfo.GetBodyInfoResponseDto;
import com.groupd.bodymanager.entity.BodyInfoEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.repository.BodyInfoRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.BodyInfoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BodyInfoServiceImplement implements BodyInfoService {
    private UserRepository userRepository;
    private BodyInfoRepository bodyInfoRepository;

    @Autowired
    public BodyInfoServiceImplement(
        UserRepository userRepository, BodyInfoRepository bodyInfoRepository){
            this.userRepository = userRepository;
            this.bodyInfoRepository = bodyInfoRepository;
    }
    
    @Override
    public ResponseEntity<ResponseDto> postBodyInfo(PostBodyInfoRequestDto dto) {

        ResponseDto body = null;
        
        int userCode = dto.getUserCode();

        try {
            // 존재하지않는 유저코드
            UserEntity existeduserCode = userRepository.findByUserCode(userCode);
            if(existeduserCode == null) {
                ResponseDto errorBody = new ResponseDto("NC", "Non-Existent User Code");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }

            BodyInfoEntity bodyInfoEntity = new BodyInfoEntity(dto);
            bodyInfoRepository.save(bodyInfoEntity);

            body = new ResponseDto("SU", "Success");

        } catch (Exception exception) {
            // 데이터베이스 오류
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
            }
            
        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    @Override
    public ResponseEntity<? super GetBodyInfoResponseDto> getBodyInfo(Integer userCode) {

        GetBodyInfoResponseDto body = null;

        try {
            // 존재하지않는 유저코드
            UserEntity existeduserCode = userRepository.findByUserCode(userCode);
            if(existeduserCode == null) {
                ResponseDto errorBody = new ResponseDto("NC", "Non-Existent User Code");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }

            BodyInfoEntity bodyInfoEntity = bodyInfoRepository.findByUserCode(userCode);
            if(bodyInfoEntity == null){
                ResponseDto errorBody = new ResponseDto("NC", "Non-Existent User Code");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }
            // 미완성
            body = new GetBodyInfoResponseDto(bodyInfoEntity, existeduserCode);

        } catch (Exception exception) {
           // 데이터베이스 오류
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
            }
        
        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    public ResponseEntity<ResponseDto> patchBodyInfo(PatchBodyInfoRequestDto dto){
        
        ResponseDto body = null;
        int userCode = dto.getUserCode();
        double height = dto.getHeight();
        double weight = dto.getWeight();
        double muscleMass = dto.getMuscleMass();
        double fatRate = dto.getFatRate();

        try {

            // UserEntity existeduserCode = userRepository.findByUserCode(userCode);
            // if(existeduserCode == null){
            //     ResponseDto erroBody = new ResponseDto("NC", "Non-Existent User Code");
            //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erroBody);
            // }

            BodyInfoEntity bodyInfoEntity = bodyInfoRepository.findByUserCode(userCode);
            if(bodyInfoEntity == null){
                return CustomResponse.notExistUserCode();
            }
            
            bodyInfoEntity.setHeight(height);
            bodyInfoEntity.setWeight(weight);
            bodyInfoEntity.setMuscleMass(muscleMass);
            bodyInfoEntity.setFatRate(fatRate);
            bodyInfoRepository.save(bodyInfoEntity);


        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}

