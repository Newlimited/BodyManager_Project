package com.groupd.bodymanager.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class selectPK implements Serializable{
    @Column(name ="user_code")
    private int userCode;
    @Column(name ="menu_code")
    private String menuCode;
}
