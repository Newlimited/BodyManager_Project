package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "Manager")
@Table(name = "Manager")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerEntity{
     
    int managerCode;
        String userPassword;
        String userNickname;
        String userPhoneNumber;
        String userAddress;
        String userGender;
        Integer userAge;
        @Id
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
