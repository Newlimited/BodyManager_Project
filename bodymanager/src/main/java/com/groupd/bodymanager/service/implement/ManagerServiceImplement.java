package com.groupd.bodymanager.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.user.PostManagerRequestDto;
import com.groupd.bodymanager.dto.response.user.GetTrainnerProfileResponse;
import com.groupd.bodymanager.entity.ManagerEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.entity.resultSet.ManagerEmailResultSet;
import com.groupd.bodymanager.repository.ManagerRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.ManagerSerivce;
import com.groupd.bodymanager.dto.response.user.GetUserResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagerServiceImplement implements ManagerSerivce{
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;

    @Override //매니저 등록 (트레이너 등록)
    public ResponseEntity<? super GetUserResponseDto> addManager(PostManagerRequestDto dto) {
        String addEmail = dto.getManagerEmail();
        try {
            // 이메일 일치 확인 - 유저이메일에서 확인하는거고...
            boolean isExistEmail = userRepository.existsByUserEmail(addEmail);
            if (!isExistEmail) {
                return CustomResponse.notExistUserEmail();
            } // 오류 반환 <이메일 없숨!>
              // 이메일 중복 확인 - 매니저이메일 리스트 안에서 확인하는것..
            boolean isAlreadyAdded = managerRepository.existsByManagerEmail(addEmail);
            if (isAlreadyAdded) {
                return CustomResponse.existUserEmail();// 오류반환 <이메일 중복>
            }
            UserEntity userEntity = userRepository.findByUserEmail(addEmail);

            
            ManagerEntity managerEntity = new ManagerEntity(addEmail, userEntity);
            managerRepository.save(managerEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.successs();
    }


    @Override //트레이너 목록조회
    public ResponseEntity<? super GetTrainnerProfileResponse> getTrainnerProfile() {
        GetTrainnerProfileResponse body = null;
        List<ManagerEmailResultSet> resultSet = managerRepository.getMangerList();
        System.out.println(resultSet);
        List<UserEntity> userEntities = new ArrayList<>();
        List<String> emailList = new ArrayList<>();
        // 매니저리스트에서 각 매니저의 email을 하나씩 빼온다.
        for(ManagerEmailResultSet result : resultSet){
            String email = result.getManagerEmail();
            emailList.add(email);
        }
        
        for(String trainnerEmail : emailList){
           UserEntity userEntity = userRepository.findByUserEmail(trainnerEmail);
            userEntities.add(userEntity);
        }
        body = new GetTrainnerProfileResponse(userEntities);

        return ResponseEntity.status(HttpStatus.OK).body(body);

        
    }
    
}
