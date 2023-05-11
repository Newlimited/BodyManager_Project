package com.groupd.bodymanager.dto.request.user;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class DeleteUserRequestDto {
    
    @NotBlank
    @Email
    private String userEmail;
    @NotBlank
    private String userPassword;
    
}
