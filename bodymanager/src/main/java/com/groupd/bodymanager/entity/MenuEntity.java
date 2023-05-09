package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Menu")
@Entity(name = "Menu")
public class MenuEntity {
    private String menuCode;
    private String menuName;
    
}
