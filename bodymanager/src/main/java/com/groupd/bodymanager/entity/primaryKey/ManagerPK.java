package com.groupd.bodymanager.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
@Data
public class ManagerPK implements Serializable{
    
    @Column(name ="manager_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer managerCode;
    @Column(name ="manager_email")
    String managerEmail;

}
