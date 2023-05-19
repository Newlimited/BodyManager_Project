package com.groupd.bodymanager.dto.response.menu;

import java.util.ArrayList;
import java.util.List;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.MenuDetailEntity;
import com.groupd.bodymanager.entity.UserMenuSelect;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUserMenuResponseDto extends ResponseDto{
    private int userCode;
    private String menuCode;
    private List<MenuDetailEntity> menuDetailList;

    public GetUserMenuResponseDto(UserMenuSelect userMenuSelect,List<MenuDetailEntity> menuDetailList) {
        super("SU","Success");
        this.userCode = userMenuSelect.getUserCode();
        this.menuCode = userMenuSelect.getMenuCode();
        this.menuDetailList = menuDetailList;

        }
    }

