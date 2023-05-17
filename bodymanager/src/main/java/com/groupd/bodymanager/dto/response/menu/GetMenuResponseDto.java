package com.groupd.bodymanager.dto.response.menu;
import com.groupd.bodymanager.dto.response.ResponseDto;

import com.groupd.bodymanager.entity.MenuEntity;
import com.groupd.bodymanager.entity.UserMenuSelect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 손좀 봐야함.
public class GetMenuResponseDto extends ResponseDto{
    private int userCode;
    private String menuCode;    
    private String menuName;

    public GetMenuResponseDto(
        MenuEntity menuEntity,
        UserMenuSelect userMenuSelect) {
            this.userCode = userMenuSelect.getUserCode();
            this.menuCode = menuEntity.getMenuCode();
            this.menuName = menuEntity.getMenuName();



    }
}