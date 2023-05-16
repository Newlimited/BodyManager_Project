package com.groupd.bodymanager.dto.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    
    @NotBlank
    @Email
    private String userEmail;
    @NotBlank
    @Size(min=8)
    private String userPassword;
    @NotBlank
    @Size(min=0, max=6)
    private String userNickname;
    @NotBlank
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$") 
    private String userPhoneNumber;
    private String userAddress;
    private String userGender;
    private Integer userAge;
}
