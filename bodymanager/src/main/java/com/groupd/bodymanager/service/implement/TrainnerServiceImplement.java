package com.groupd.bodymanager.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.dto.response.user.GetTrainnerProfileResponse;
import com.groupd.bodymanager.entity.ManagerEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.entity.resultSet.ManagerEmailResultSet;
import com.groupd.bodymanager.repository.ManagerRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.TrainnerSerivce;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainnerServiceImplement implements TrainnerSerivce{
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;

    @Override
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
