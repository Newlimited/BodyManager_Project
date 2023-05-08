package com.groupd.bodymanager.dto.request.user;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PatchUserRequestDto {
    @Id
    @NotBlank
    @Email
    private String userEmail;
    @NotBlank
    @Min(8)
    private String userPassword;
    @NotBlank
    @Max(6)
    private String userNickname;
    @NotBlank
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$") 
    private String userPhoneNumber;
    private String userAddress;
    private String userGender;
    private Integer userAge;
}
