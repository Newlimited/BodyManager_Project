package com.groupd.bodymanager.dto.response.auth;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.groupd.bodymanager.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GetAuthResponseDto extends ResponseDto {
     
    private int userCode;
    private String token;
    private int expirationDate;  
    public GetAuthResponseDto(int userCode){
        super("SU", "Sucess");
        this.userCode = userCode;
    }
    public GetAuthResponseDto(String token, int userCode){
        super("SU", "Sucess");
        this.token = token;
        this.expirationDate = 3600;
    }

}