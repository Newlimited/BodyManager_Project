package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.groupd.bodymanager.dto.request.user.PostManagerRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity(name = "Manager")
@Table(name = "Manager")
@Data
@NoArgsConstructor
public class ManagerEntity{
        int managerCode;
         String userPassword;
         String userNickname;
         String userPhoneNumber;
         String userAddress;
         String userGender;
         Integer userAge;
         String managerEmail;
    
        public ManagerEntity(UserEntity dto){
            this.managerCode = dto.getUserCode();
            this.managerEmail = dto.getUserEmail();
            this.userNickname = dto.getUserNickname();
            this.userPhoneNumber = dto.getUserPhoneNumber();
            this.userAddress = dto.getUserAddress();
            this.userGender = dto.getUserGender();
            this.userPassword = dto.getUserPassword();
            this.userAge = dto.getUserAge();
        }
        public ManagerEntity(String email){
            this.managerEmail = email;
        }
}
