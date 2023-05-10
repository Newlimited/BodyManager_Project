package com.groupd.bodymanager.dto.response.user;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.ManagerEntity;
import com.groupd.bodymanager.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto extends ResponseDto{
    
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
    public GetUserResponseDto(ManagerEntity managerEntity){
        this.userNickname = managerEntity.getUserNickname();
        this.userPhoneNumber = managerEntity.getUserPhoneNumber();
        this.userAddress = managerEntity.getUserAddress();
        this.userGender = managerEntity.getUserGender();
        this.userAge = managerEntity.getUserAge();
    }
}
