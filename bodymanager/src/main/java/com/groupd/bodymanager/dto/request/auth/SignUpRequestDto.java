package com.groupd.bodymanager.dto.request.auth;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SignUpRequestDto {
    @Id
    @NotBlank
    private String userEmail;
    @NotBlank
    @Min(8)
    private String userPassword;
    @NotBlank
    @Max(6)
    private String userNickname;
    @NotBlank
    @Min(10)
    @Max(11)
    private String userPhoneNumber;
    private String userAddress;
    private String userGender;
    private Integer userAge;
}
