package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "MenuDetail")
@Entity(name = "MenuDetail")
public class MenuDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int menuIndex;
    private String menuCode;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursady;
    private String friday;
    private String saturday;
    private String sunday;
    private String time;
    
}
