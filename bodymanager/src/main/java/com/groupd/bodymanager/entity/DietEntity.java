package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Diet")
@Entity(name = "Diet")
public class DietEntity {

    @Id
    private int dietNumber;
    private String day;
    private String menuCode;
    private int userCode;

    
}
