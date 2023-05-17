package com.groupd.bodymanager.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.IdClass;

import lombok.Data;

@Data

public class userPK implements Serializable{
    @Column(name ="user_code")
    private int userCode;
    @Column(name ="user_email")
    private String userEmail;
}
