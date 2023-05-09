package com.groupd.bodymanager.dto.request.user;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class DeleteUserRequestDto {
    

    @NotBlank
    @Email
    private String userEmail;
    @NotBlank
    private String userPassword;
    
}
