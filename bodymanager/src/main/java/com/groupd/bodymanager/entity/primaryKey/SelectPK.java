package com.groupd.bodymanager.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import com.groupd.bodymanager.entity.UserMenuSelect;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SelectPK implements Serializable{
    @Column(name ="user_code")
    private Integer userCode;
    @Column(name ="menu_code")
    private String menuCode;

    public SelectPK(UserMenuSelect userMenuSelect){
        this.userCode = userMenuSelect.getUserCode();
        this.menuCode = userMenuSelect.getMenuCode();
    }
}
