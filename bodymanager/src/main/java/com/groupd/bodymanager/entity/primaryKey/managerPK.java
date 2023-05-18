package com.groupd.bodymanager.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class managerPK implements Serializable{
  
    @Column(name ="manager_email")
    private String managerEmail;
}

