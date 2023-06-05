package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Manager")
@Table(name = "Manager")
@Data
@AllArgsConstructor
@NoArgsConstructor
// @IdClass(ManagerPK.class)
public class ManagerEntity {

   
    @Email
    String managerEmail;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer managerCode;
    String managerNickname;
    String managerPhoneNumber;
    String managerGender;
    Integer managerAge;



    public ManagerEntity(String email, UserEntity userEntity) {
   
        this.managerEmail = email;
       
        this.managerPhoneNumber = userEntity.getUserPhoneNumber();
        this.managerGender = userEntity.getUserGender();
        this.managerAge = userEntity.getUserAge();
        this.managerNickname = userEntity.getUserNickname();
    }

}
