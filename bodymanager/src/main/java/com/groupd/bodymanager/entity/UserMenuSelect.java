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
@Table(name = "UserMenuSelect")
@Entity(name = "UserMenuSelect")
public class UserMenuSelect {
    
    private String menuCode;
    @Id
    private int userCode;
    UserMenuSelect(UserEntity userEntity, MenuEntity menuEntity){
        this.menuCode = menuEntity.getMenuCode();
        this.userCode = userEntity.getUserCode();
    }   
}
