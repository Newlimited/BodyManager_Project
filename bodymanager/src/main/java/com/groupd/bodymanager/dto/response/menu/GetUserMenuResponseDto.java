package com.groupd.bodymanager.dto.response.menu;

import java.util.ArrayList;
import java.util.List;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.MenuDetailEntity;
import com.groupd.bodymanager.entity.UserMenuSelect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUserMenuResponseDto extends ResponseDto{
    private int userCode;
    private String menuCode;
    private List<MenuDetail> menuDetailList;

    public GetUserMenuResponseDto(UserMenuSelect userMenuSelect,List<MenuDetailEntity> menuDetailList) {
        super("SU","Success");
        this.userCode = userMenuSelect.getUserCode();
        this.menuCode = userMenuSelect.getMenuCode();
        this.menuDetailList = MenuDetail.createList(menuDetailList);

        }
    }


@Data
@AllArgsConstructor
class MenuDetail {
    private String time;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    MenuDetail(MenuDetailEntity menuDetailEntity) {
        this.time = menuDetailEntity.getTime();
        this.monday = menuDetailEntity.getMonday();
        this.tuesday = menuDetailEntity.getTuesday();
        this.wednesday = menuDetailEntity.getWednesday();
        this.thursday = menuDetailEntity.getThursday();
        this.friday = menuDetailEntity.getFriday();;
        this.saturday = menuDetailEntity.getSaturday();
    }

    static List<MenuDetail> createList(List<MenuDetailEntity> menuDetailEntities) {
        List<MenuDetail> menuList = new ArrayList<>();
        for(MenuDetailEntity menuDetailEntity : menuDetailEntities) {
            MenuDetail menuDetail = new MenuDetail(menuDetailEntity);
            menuList.add(menuDetail);
        }
        return menuList;

    }
    
}