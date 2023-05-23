package com.groupd.bodymanager.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupd.bodymanager.common.CustomResponse;
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
    private final UserRepository userRepository;
    private final BodyInfoRepository bodyInfoRepository;

   
    @Override
    public ResponseEntity<ResponseDto> postBodyInfo(String email, PostBodyInfoRequestDto dto) {

        ResponseDto body = null;
        UserEntity userEntity = userRepository.findByUserEmail(email);
        Integer userCode = userEntity.getUserCode();

        double heightForBmiIndex = dto.getHeight()/100 ;
        double weightForBmiIndex = dto.getWeight();
        double calculateForBmiIndex = weightForBmiIndex/(heightForBmiIndex*heightForBmiIndex);
        double decimalPoint = Math.round(calculateForBmiIndex*100)/100.0;
    
        BodyInfoEntity bodyInfoEntity = new BodyInfoEntity(dto);
        bodyInfoEntity.setBmiIndex(decimalPoint);
        Double bmiReult = bodyInfoEntity.getBmiIndex();

        try {
            
            // 존재하지않는 유저코드
            UserEntity existeduserCode = userRepository.findByUserCode(userCode);
            if(existeduserCode == null) {
                return CustomResponse.notExistUserCode();
            }
            // kg/㎡. BMI가 18.5 이하면 저체중 ／ 18.5 ~ 22.9 사이면 정상 ／ 23.0 ~ 24.9 사이면 과체중 ／ 25.0 / 비만 

            if(bmiReult <= 18.5 ) {
                bodyInfoEntity.setBmiResult("저체중");
            }
            else if(bmiReult <= 22.9){
                bodyInfoEntity.setBmiResult("정상");
            }
            else if(bmiReult <= 24.9){
                bodyInfoEntity.setBmiResult("과체중");
            }
            else{
                bodyInfoEntity.setBmiResult("비만");
            }
           
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
            if (userCode == null)
                return CustomResponse.validationFaild();
            // 존재하지않는 유저코드
            List<BodyInfoEntity> bodyInfoEntities = bodyInfoRepository.findByUserCode(userCode);
            if (bodyInfoEntities == null) {
                return CustomResponse.notExistUserCode();
            }

            UserEntity userEntity = userRepository.findByUserCode(userCode);
            body = new GetBodyInfoResponseDto(bodyInfoEntities, userEntity);

        } catch (Exception exception) {
            // 데이터베이스 오류
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

}
