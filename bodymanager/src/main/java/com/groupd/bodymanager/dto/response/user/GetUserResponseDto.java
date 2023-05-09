package com.groupd.bodymanager.dto.response.user;

import com.groupd.bodymanager.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto {
    
    private String userNickname;
    private String userPhoneNumber;
    private String userAddress;
    private String userGender;
    private int userAge;

    public GetUserResponseDto(UserEntity userEntity){
        this.userNickname = userEntity.getUserNickname();
        this.userPhoneNumber = userEntity.getUserPhoneNumber();
        this.userAddress = userEntity.getUserAddress();
        this.userGender = userEntity.getUserGender();
        this.userAge = userEntity.getUserAge();
    }
}
