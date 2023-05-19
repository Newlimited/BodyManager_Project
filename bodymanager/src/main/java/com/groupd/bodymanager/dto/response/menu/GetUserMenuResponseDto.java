package com.groupd.bodymanager.dto.response.menu;

import java.util.List;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.UserMenuSelect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUserMenuResponseDto extends ResponseDto{
    private int userCode;
    private String menuCode;
    private List<Menu> menuList;

    public GetUserMenuResponseDto(UserMenuSelect userMenuSelect) {
        
    }

    
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Menu {

}
