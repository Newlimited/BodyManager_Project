package com.groupd.bodymanager.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data

public class BodyPK implements Serializable{
    @Column(name ="user_code")
    private Integer userCode;
    @Column(name ="record_date")
    private String recordDate;
}
