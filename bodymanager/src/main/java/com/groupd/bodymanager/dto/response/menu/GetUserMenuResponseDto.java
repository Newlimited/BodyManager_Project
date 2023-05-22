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
    private List<SelectMenuDetail> menuDetailList;

    public GetUserMenuResponseDto(UserMenuSelect userMenuSelect,
            List<MenuDetailEntity> menuDetailEntities) {
        super("SU", "Success");
        this.userCode = userMenuSelect.getUserCode();
        this.menuCode = userMenuSelect.getMenuCode();
        SelectMenuDetail menuDetail = new SelectMenuDetail();
        
        this.menuDetailList = menuDetail.seletedMenuDetail(menuDetailEntities);
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class SelectMenuDetail {

    private String time;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    SelectMenuDetail(MenuDetailEntity menuDetailEntity) {

        this.time = menuDetailEntity.getTime();
        this.monday = menuDetailEntity.getMonday();
        this.tuesday = menuDetailEntity.getTuesday();
        this.wednesday = menuDetailEntity.getWednesday();
        this.thursday = menuDetailEntity.getThursday();
        this.friday = menuDetailEntity.getFriday();
        this.saturday = menuDetailEntity.getSaturday();
        this.sunday = menuDetailEntity.getSunday();
    }
    List<SelectMenuDetail> seletedMenuDetail(List<MenuDetailEntity> menuDetailEntities){
   
        List<SelectMenuDetail> menuDetailList = new ArrayList<>();

    for (MenuDetailEntity menuDetailEntity : menuDetailEntities) {
        SelectMenuDetail menuDetail = new SelectMenuDetail(menuDetailEntity);
        menuDetailList.add(menuDetail);
    }
    return menuDetailList;
}
}