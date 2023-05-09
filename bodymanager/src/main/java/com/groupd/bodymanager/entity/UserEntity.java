package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD

import com.groupd.bodymanager.dto.request.user.SignInRequestDto;
=======
>>>>>>> d83a2670bbe1c12246507be600697ad0b7f9d70e
import com.groupd.bodymanager.dto.request.user.SignUpRequestDto;
import com.groupd.bodymanager.dto.response.user.GetAuthResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "User")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCode;
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userPhoneNumber;
    private String userAddress;
    private String userGender;
    private Integer userAge;
    

       public UserEntity(SignUpRequestDto dto, int userCode) {
        
        this.userCode = userCode;
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
        this.userNickname = dto.getUserNickname();
        this.userPhoneNumber = dto.getUserPhoneNumber();
        this.userGender = dto.getUserGender();
        this.userAge = dto.getUserAge();
        this.userAddress = dto.getUserAddress();
        
    }
    
}
