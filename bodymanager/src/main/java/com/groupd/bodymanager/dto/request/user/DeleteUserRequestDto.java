package com.groupd.bodymanager.dto.request.user;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class DeleteUserRequestDto {
    
    @Id
    @NotBlank
    @Email
    private String userEmail;
    @NotBlank
    private String userPassword;
    
}
