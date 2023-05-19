package com.groupd.bodymanager.dto.request.user;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PatchUserRequestDto {
    
   
    @NotBlank
    @Size(min=8)
    private String userPassword;
    private String userNewPassword;
    private String userNewPasswordCheck;
    @NotBlank
    @Size(min=0, max=6)
    private String userNickname;
    private String userPhoneNumber;
    private String userAddress;
    private String userGender;
    private Integer userAge;
}
