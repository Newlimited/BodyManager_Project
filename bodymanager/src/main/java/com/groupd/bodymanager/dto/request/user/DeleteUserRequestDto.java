package com.groupd.bodymanager.dto.request.user;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class DeleteUserRequestDto {
    
        @NotBlank
        @Email
        private String userEmailCheck;
        @NotBlank
        private String userPassword;
        
    }