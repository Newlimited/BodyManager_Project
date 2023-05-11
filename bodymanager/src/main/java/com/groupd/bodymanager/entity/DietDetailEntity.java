package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "DietDetail")
@Entity(name = "DietDetail")
public class DietDetailEntity {
    private int dietDetailNumber;
    private int dietNumber;
    private String menuCode;
    private int userCode;
    private String item;
    private String time;
    
}
