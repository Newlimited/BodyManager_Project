package com.groupd.bodymanager.dto.response.user;

import java.util.ArrayList;
import java.util.List;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetTrainnerProfileResponse extends ResponseDto {
    private List<Trainner> trainnerList;

    public GetTrainnerProfileResponse(List<UserEntity> userEntities){
        super("SU" , "Success");
    
        List<Trainner> trainnerList = new ArrayList<>();
        
        for(UserEntity userEntity : userEntities){
            Trainner Trainner = new Trainner(userEntity);
            
            trainnerList.add(Trainner);
        }
        this.trainnerList = trainnerList;

    }

}
    @Data
    @NoArgsConstructor
    class Trainner {
        private String trainnerEmail;
        private String trainnerNickname;
        private String trainnerPhoneNumber;
        private String trainnerGender;
        private Integer trainnerAge;

        Trainner(UserEntity userEntity) {
            this.trainnerEmail = userEntity.getUserEmail();
            this.trainnerNickname = userEntity.getUserNickname();
            this.trainnerPhoneNumber = userEntity.getUserPhoneNumber();
            this.trainnerGender = userEntity.getUserGender();
            this.trainnerAge = userEntity.getUserAge();
        }
}
